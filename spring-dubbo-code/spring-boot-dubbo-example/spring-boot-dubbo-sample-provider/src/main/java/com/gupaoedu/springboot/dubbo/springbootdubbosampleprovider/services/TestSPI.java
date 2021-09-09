package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.apache.dubbo.rpc.protocol.dubbo.DubboExporter;
import org.apache.dubbo.rpc.protocol.dubbo.DubboInvoker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestSPI {
    public static void main(String[] args) {
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        URL url = null;
        try {
            url = new URL("jy", "1.2.3.4", 1010, "path1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Invoker<Object> invoker = new DubboInvoker<Object>(Object.class,url,null);

        LoadBalance myBalance=ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("ja");


        //protocol.export(invoker);

        List<Invoker<Object>> list=new ArrayList<>();
        list.add(invoker);
        Invoker<Object> invoker1 = myBalance.select(list, url, null);
        System.out.println(invoker1);
    }

}
