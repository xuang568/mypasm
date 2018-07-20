package com.dongzheng.pasm.api.impl;

import com.dongzheng.pasm.api.ClientQueryWbServices;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.Iterator;

@WebService
public class ClientQueryWbServicesImpl implements ClientQueryWbServices {
    @Override
    public String clientQueryNotify(String data) {
        System.out.println("请求过来了：data:"+data);
        //解析xml
        try {
            Document dom = null;
            dom = DocumentHelper.parseText(data);
            Element root = dom.getRootElement();
            Iterator iter = root.elementIterator("PBOCDATA");
            // 遍历ROOT节点
            while (iter.hasNext()) {
                Element recordEless = (Element) iter.next();
                String name = recordEless.elementTextTrim("Name");
                String id_number = recordEless.element("Id_number").getText();
                String pboc_report = recordEless.element("Pboc_report").getText();
                String pboc_no = recordEless.element("Pboc_no").getText();
                System.out.println(name+id_number+pboc_no+pboc_report);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<InputXML xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                "<ROOT>" +
                "<Flag>True</Flag>" +
                "<ErrorMessage>null</ErrorMessage>" +
                "<ResponseDate>2018-07-13 11:35:00</ResponseDate>" +
                "</ROOT>" +
                "</InputXML>";
        return result;
    }

        //通过EndPoint(端点服务)发布一个WebService
    public static void main(String[] args) {
        //1,本地的服务地址;2,提供服务的类;
        Endpoint.publish("http://localhost:8090/service/ClientQueryWbServices", new ClientQueryWbServicesImpl());
        System.out.println("发布成功!");
        //发布成功后 在浏览器输入 http://localhost:8090/service/ClientQueryWbServices?wsdl
    }
}

