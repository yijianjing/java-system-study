package com.gupaoedu.springcloud.dubbo.springclouddubbosampleconsumer;

import com.gupaoedu.springcloud.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@SpringBootApplication
public class SpringCloudDubboSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboSampleConsumerApplication.class, args);
    }

    @Reference
    ISayHelloService sayHelloService;

    @GetMapping("/say")
    public String say(){
        return sayHelloService.sayHello("Mic");
    }


}
