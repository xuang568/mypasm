package com.dongzheng.pasm.controller;


import com.dongzheng.pasm.base.Data;
import com.dongzheng.pasm.base.ResDTO;
import com.dongzheng.pasm.core.common.JsonResult;
import com.dongzheng.pasm.core.entity.Resource;
import com.dongzheng.pasm.core.entity.Role;
import com.dongzheng.pasm.core.service.IResourceService;
import com.dongzheng.pasm.core.vo.ZtreeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@CrossOrigin
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {
    @Autowired
    private IResourceService resourceService;

    @RequestMapping("/tree/{resourceId}")
    @ResponseBody
    public List<ZtreeView> tree(@PathVariable Integer resourceId) {
        List<ZtreeView> list = resourceService.tree(resourceId);
        return list;
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        List<Resource> list = resourceService.findAll();
        map.put("list", list);
        return "resource/index";
    }

    @ResponseBody
    @RequestMapping(value = {"/index"}, method = RequestMethod.POST)
    public ResDTO<Data> index(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        ResDTO<Data> resDTO = new ResDTO<>();
        Data data = new Data();
        List list;
        try {
            Page<Resource> page = null;
            System.out.println("请求入参：" + pageNum + ":" + pageSize);
            Pageable pageable = new PageRequest(pageNum, pageSize);
            page = resourceService.findByPage(pageable);
            data.setList(page);
            resDTO.setSuccess(true);
            resDTO.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            resDTO.setSuccess(false);
        }
        return resDTO;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        List<Resource> list = resourceService.findAll();
        map.put("list", list);
        return "resource/form";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Resource resource = resourceService.find(id);
        map.put("resource", resource);

        List<Resource> list = resourceService.findAll();
        map.put("list", list);
        return "resource/form";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Resource resource, Integer parentId, ModelMap map) {
        try {
            if (parentId != null) {
                Resource parent = new Resource();
                parent.setId(parentId);
                resource.setParent(parent);
            }
            resourceService.saveOrUpdate(resource);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            resourceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
