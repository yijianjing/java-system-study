package com.gupaoedu.springboot.springbootnacos;

import java.sql.SQLOutput;

public class DemoMain {


    public static void main(String[] args) {
        Demo demo=new Demo(1,1);
        for(int i=0;i<10;i++){
            System.out.println(demo.getId());
        }

    }
}
