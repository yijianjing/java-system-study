package com.gupaoedu.dubbo.server;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class LoginServiceImpl implements ILoginService{

    @Override
    public String login(String username, String password) {
        //写业务逻辑
        if(username.equals("admin")&&password.equals("admin")){
            return "SUCCESS";
        }
        return "FAILED";
    }
}
