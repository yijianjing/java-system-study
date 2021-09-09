package com.gupaoedu.springboot.dubbo.springbootdubbosampleconsumer;

import com.gupaoedu.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootDubboSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboSampleConsumerApplication.class, args);
    }

    @DubboReference(registry = {"hunan"},version = "1.0")
    ISayHelloService sayHelloService;

    @GetMapping("/say")
    public String say(){
        return sayHelloService.sayHello("Mic");
    }

}
