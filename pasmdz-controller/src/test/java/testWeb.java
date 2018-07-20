import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

public class testWeb {
    public static void main(String[] args) {
        String result = null;
        try {
            String endpoint = "http://localhost:8090/service/ClientQueryWbServices?wsdl";
            //直接引用远程的wsdl文件
            //以下都是套路
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            /**
             *注意这里，要设置Namespace
             */
            call.setOperationName(new QName("http://impl.api.pasm.dongzheng.com/","clientQueryNotify"));//WSDL里面描述的接口名称
            call.addParameter("arg0", XMLType.XSD_STRING,
                    ParameterMode.IN);//接口的参数
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
            result = (String)call.invoke(new Object[]{"xml"});
            //给方法传递参数，并且调用方法
            System.out.println("result is :"+result);
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }
        System.out.println(result);
    }

}
