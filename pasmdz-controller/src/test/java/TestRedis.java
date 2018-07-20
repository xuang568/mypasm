import com.dongzheng.pasm.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public void contextLoads() {
    }

    @Test
    public void test(){

            ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
            opsForValue.set("redisKey","cluster test");
            System.out.println(opsForValue.get("redisKey"));


    }

    public static void main(String[] args) {
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        ValueOperations<String, Object> value = redisTemplate.opsForValue();
        System.out.println(redisTemplate);
        System.out.println(value);
        redisTemplate.opsForValue().set("you","name");

        System.out.println( redisTemplate.opsForValue().get("you"));
    }
}
