package com.gupaoedu.springcloud.dubbo.springclouddubbosampleprovider.services;

import com.gupaoedu.springcloud.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@Service
public class SayHelloServiceImpl implements ISayHelloService{

    @Override
    public String sayHello(String msg) {
        return "Hello, GuPaoEdu.cn";
    }
}
