package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services;


import com.gupaoedu.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.Protocol;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@DubboService(filter = "ff",registry = {"shanghai","hunan"},version = "1.0",protocol = {"dubbo"})
public class SayHelloServiceImpl implements ISayHelloService {

    @Override
    public String sayHello(String msg) {
        return "[version1.0]Hello,"+msg+" GuPaoEdu.cn";
    }
}
