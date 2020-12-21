package com.cn.www.chapter01;

public class StringTest {
    public static void main(String[] args) {
        String str = new String("hello")+new String("world");
        String str1 = "helloworld";
        System.out.println(str == str1);//false
        String str2 = new String("helloworld");
        System.out.println(str1==str2);//false
    }
}
