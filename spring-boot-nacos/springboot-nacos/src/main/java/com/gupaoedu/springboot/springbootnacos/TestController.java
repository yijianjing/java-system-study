package com.gupaoedu.springboot.springbootnacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
@RestController
public class TestController {

    @NacosInjected
    private NamingService namingService;  //服务注册功能的Service

    @GetMapping("/get")
    public String get() throws NacosException {

        return namingService.
                getAllInstances("SpringBoot-Nacos").toString();
    }

    @GetMapping("/registry")
    public String registry() throws NacosException {
        Instance instance=new Instance();
        instance.setClusterName("TestCluster");
        instance.setEnabled(true);
        instance.setEphemeral(true);  //临时节点/持久化节点, CP（Raft）, AP（Distro）
        instance.setIp("49.235.118.218");
        instance.setPort(8888);
        instance.setWeight(10);  //1~100
        namingService.registerInstance("SpringBoot-Nacos",instance);
        return "SUCCESS";
    }

}
