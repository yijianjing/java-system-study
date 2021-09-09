package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services;

import org.apache.dubbo.rpc.*;

public class Myfilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("abcabc");
        return invoker.invoke(invocation);
    }
}
