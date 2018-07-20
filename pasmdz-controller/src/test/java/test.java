import com.alibaba.fastjson.JSONArray;
import com.dongzheng.pasm.Application;
import com.dongzheng.pasm.core.dao.CrawlerRequestDao;
import com.dongzheng.pasm.core.dao.IBlacklistDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class test {

    @Autowired
    private IBlacklistDao iBlacklistDao;

    @Autowired
    private CrawlerRequestDao iCrawlerRequestDao;

    @Test
    public void test(){

        try {
           /* Blacklist blacklist = iBlacklistDao.test("413022197403140016");
            String s = JSONArray.toJSONString(blacklist);*/

            List<Object> crawlerRequests = iCrawlerRequestDao.queryInfo("452502197102085517");
            String s = JSONArray.toJSONString(crawlerRequests);
            System.out.println(s);
            System.out.println("start python");
            //需传入的参数
            String a = "{id:123},{name:xiaoming}", b = "bbb", c = "ccc", d = "ddd";

            String[]  args  = new String[] { "python", "C:\\Users\\xua\\Desktop\\test.py",s};

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

    public static void main(String[] args) {
        List list=new ArrayList();
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("D:/pythonLib/hello.py");

    }
}




