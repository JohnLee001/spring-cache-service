package com.example.test;


import org.apache.commons.lang3.StringUtils;

public class TestDemo01 {

    public static void main(String[] args) {
        String str = null;
        System.out.println(str.isEmpty());
        System.out.println(str.isBlank());
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(StringUtils.isBlank(str));
        System.out.println("result ="+StringUtils.trim(str)+"====");//去除首尾空格
        System.out.println("result ="+str+"====");
    }
}
