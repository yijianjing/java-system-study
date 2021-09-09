package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.protocol.dubbo.DubboExporter;

public class JyProtocol  implements Protocol {
    @Override
    public int getDefaultPort() {
        return 0;
    }

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        System.out.println("jy export");
        Exporter<T> exporter = new DubboExporter<T>(invoker,null,null);
        return exporter;
    }

    @Override
    public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        System.out.println("jy refer");
        return null;
    }

    @Override
    public void destroy() {

    }
}
