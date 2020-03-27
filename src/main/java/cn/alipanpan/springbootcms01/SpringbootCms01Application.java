package cn.alipanpan.springbootcms01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class SpringbootCms01Application {

    public static void main(String[] args) {
       // SpringApplication.run(SpringbootCms01Application.class, args);
        ConfigurableApplicationContext run = run(SpringbootCms01Application.class, args);
        System.out.print("--------------李盼");
    }

}
