package com.gupaoedu.springcloud.dubbo.springclouddubbosampleprovider;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudDubboSampleProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudDubboSampleProviderApplication.class, args);
    }

}
