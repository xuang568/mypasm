package com.dongzheng.pasm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = {"/", "/index"})
    public String index() {

        return "index";
    }
}
