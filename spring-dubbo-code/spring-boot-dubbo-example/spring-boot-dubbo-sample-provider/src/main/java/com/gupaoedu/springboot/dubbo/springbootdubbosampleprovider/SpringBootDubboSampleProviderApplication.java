package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.apache.dubbo.rpc.protocol.dubbo.DubboInvoker;
import org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;

import java.util.ServiceLoader;

@DubboComponentScan(basePackages = "com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services")
@SpringBootApplication
public class SpringBootDubboSampleProviderApplication {

    public static void main(String[] args) {
       // ServiceLoader.load(DubboService.class);
//        RandomLoadBalance rd= (RandomLoadBalance) ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("random");
      //   Protocol rd2= (Protocol) ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

        SpringApplication.run(SpringBootDubboSampleProviderApplication.class, args);
    }




}
