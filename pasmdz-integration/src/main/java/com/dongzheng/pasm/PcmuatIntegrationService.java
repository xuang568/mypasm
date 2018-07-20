package com.dongzheng.pasm;

import com.dongzheng.pasm.Req.PcmuatReqDTO;
import com.dongzheng.pasm.utils.DateUtil;
import com.dongzheng.pasm.utils.WebServiceUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * zhong ke ruan ren hang zheng xin fu wu
 * */
@Service
public class PcmuatIntegrationService {
    private static Logger logger = Logger.getLogger(PcmuatIntegrationService.class);

    String result="fail";

    public String queryPcmuat(PcmuatReqDTO pcmuatReqDTO) {

        String str ="<?xml version=\"1.0\"?>"
                +"<Root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">"
                +"<Info>"
                +"<application_number>"+pcmuatReqDTO.getApplicationNumber()+"</application_number>"
                +"<applicant_nme>"+pcmuatReqDTO.getApplicantName()+"</applicant_nme>"
                +"<id_card_typ>"+pcmuatReqDTO.getIdCardType()+"</id_card_typ>"
                +"<id_card_nbr>"+pcmuatReqDTO.getIdCardNbr()+"</id_card_nbr>"
                +"<application_role>"+pcmuatReqDTO.getApplicationRole()+"</application_role>"
                +"<queryreason>"+pcmuatReqDTO.getQueryReason()+"</queryreason>"
                +"</Info>"
                +"<applyno>"+pcmuatReqDTO.getApplicationNumber()+"</applyno>"
                +"<request_date>"+DateUtil.format(pcmuatReqDTO.getRequestDate())+"</request_date>"
                +"<Operator>"+pcmuatReqDTO.getApplicantName()+"</Operator>"
                +"</Root>";
        String res = null;
        try {

            logger.info("WebServiceUtil queryPcmuat params:{}"+str);
            res = WebServiceUtil.queryPcmuat("http://172.16.10.71:8080/pcmuat/services/pboc", "getXML", str);
            logger.info("WebServiceUtil queryPcmuat result:{}"+res);
            if("".equals(res)){
                return result;
            }
            //解析xml
            Document dom= null;
            dom = DocumentHelper.parseText(res);
            Element root = dom.getRootElement();
            Iterator iter = root.elementIterator("ROOT");
            // 遍历ROOT节点
            while (iter.hasNext()) {
                Element recordEless = (Element) iter.next();
                String flag = recordEless.elementTextTrim("Flag");
                String errorMessage = recordEless.element("ErrorMessage").getText();
                String responseDate = recordEless.element("ResponseDate").getText();
                result=flag;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
