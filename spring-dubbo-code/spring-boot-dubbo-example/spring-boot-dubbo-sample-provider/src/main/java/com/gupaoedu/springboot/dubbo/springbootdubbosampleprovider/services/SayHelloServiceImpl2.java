package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services;


import com.gupaoedu.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@DubboService(registry = {"shanghai","hunan"},version = "2.0")
public class SayHelloServiceImpl2 implements ISayHelloService {

    @Override
    public String sayHello(String msg) {
        return "[Version2.0]Hello,"+msg+" GuPaoEdu.cn";
    }
}
