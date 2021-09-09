package com.gupaoedu.dubbo;

import com.gupaoedu.dubbo.server.ILoginService;
import com.gupaoedu.springboot.dubbo.ISayHelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ISayHelloService loginService=null;
        ApplicationContext context=new
                ClassPathXmlApplicationContext
                ("classpath:META-INF/spring/application.xml");
        loginService=context.getBean(ISayHelloService.class);
        System.out.println(loginService.sayHello("admin"));
    }
}
