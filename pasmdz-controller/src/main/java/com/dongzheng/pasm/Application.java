package com.dongzheng.pasm;

import com.dongzheng.pasm.api.impl.ClientQueryWbServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.xml.ws.Endpoint;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class Application extends SpringBootServletInitializer {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //1,本地的服务地址;2,提供服务的类;
        Endpoint.publish("http://localhost:8090/service/ClientQueryWbServices", new ClientQueryWbServicesImpl());
        System.out.println("webservice:发布成功!");
        //发布成功后 在浏览器输入 http://localhost:8090/service/ClientQueryWbServices?wsdl
        logger.debug("应用pasmdz:启动成功");
    }

}
