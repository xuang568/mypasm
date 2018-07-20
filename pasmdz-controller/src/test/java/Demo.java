import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo {

    public static void main(String[] strings) {
        try {

            System.out.println("start python");
            //需传入的参数
            String a = "{id:123},{'name':xiaoming}", b = "bbb", c = "ccc", d = "ddd";

           String[]  args  = new String[] { "python", "C:\\Users\\xua\\Desktop\\test.py"};
            //String[]  args  = new String[] { "python", "D:\\pythonLib\\test.py",a,b,c,d };
           // JSONObject json = (JSONObject)JSON.toJSON(args);
            Process pr = Runtime.getRuntime().exec(args);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                //line = decodeUnicode(line);
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
