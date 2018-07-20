import com.dongzheng.pasm.Req.PcmuatReqDTO;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Webservice_Dom4j {

    public static void main(String[] args) throws ParseException {

      /*  String str ="<?xml version=\"1.0\"?>"
                +"<Root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">"
                +"<Info>"
                +"<application_number>Br-A028883000</application_number>"
                +"<applicant_nme>贡荣娣</applicant_nme>"
                +"<id_card_typ>0</id_card_typ>"
                +"<id_card_nbr>110110194502091523</id_card_nbr>"
                +"<application_role>A</application_role>"
                +"<queryreason>01</queryreason>"
                +"</Info>"
                +"<applyno>20161104000019</applyno>"
                +"<request_date>2016-11-04 17:31:31</request_date>"
                +"<Operator>admin</Operator>"
                +"</Root>";*/
        PcmuatReqDTO pcmuatReqDTO =new PcmuatReqDTO();
        pcmuatReqDTO.setApplyNo("Br-A028883000");
        pcmuatReqDTO.setOperator("ITadmin");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pcmuatReqDTO.setRequestDate(new Date());
        pcmuatReqDTO.setApplicationNumber("Br-A028883000");
        pcmuatReqDTO.setApplicantName("贡荣娣");
        pcmuatReqDTO.setApplicationRole("A");
        pcmuatReqDTO.setIdCardType("0");
        pcmuatReqDTO.setIdCardNbr("110110194502091523");
        pcmuatReqDTO.setQueryReason("01");
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
                +"<request_date>"+ sdf.format(pcmuatReqDTO.getRequestDate())+"</request_date>"
                +"<Operator>"+pcmuatReqDTO.getApplicantName()+"</Operator>"
                +"</Root>";


        String res = null;
        try {
            res = ConnectionToJava("http://172.16.10.71:8080/pcmuat/services/pboc", "getXML", str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("与服务器交易成功！交易结果:" + res);

        //解析xml

        Document dom= null;
        try {
            dom = DocumentHelper.parseText(res);

        Element root = dom.getRootElement();
            Iterator iter = root.elementIterator("ROOT"); // 获取根节点下的子节点ROOT
            // 遍历body节点
            while (iter.hasNext()) {

                Element recordEless = (Element) iter.next();
                String flag = recordEless.elementTextTrim("Flag"); // 拿到body节点下的子节点result值
                String errorMessage = recordEless.element("ErrorMessage").getText();
                String responseDate = recordEless.element("ResponseDate").getText();
                System.out.println("flag:" + flag);
                System.out.println("errorMessage:" + errorMessage);
                System.out.println("responseDate:" + responseDate);

            }
        }
        catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static String  ConnectionToJava(String url, String OperatorName,String xml) throws Exception {
        // try {
        Service service = new Service(); // 创建一个Service实例，注意是必须的！
        Call call =(Call) service.createCall(); // 创建Call实例，也是必须的
        call.setTargetEndpointAddress(new java.net.URL(url)); // 为Call设置服务的位置
        call.setOperationName(OperatorName);
        call.setTimeout(new Integer(-1));
        String res="";;
        if(xml==null||xml.equals("")){
            res = (String) call.invoke(new Object[] {});
        }else
        {
            System.out.println("xml-------------------------------"+xml);
           res = (String) call.invoke(new Object[] {xml});
        }
        return res;
       /*} catch (Exception ex) {
           ex.printStackTrace();
           mCErrors.addOneError(ex.getMessage());
           return "";
       }*/
    }
}
