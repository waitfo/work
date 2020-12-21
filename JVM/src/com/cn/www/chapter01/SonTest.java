package com.cn.www.chapter01;

/**
 * 成员变量的初始化过程：①默认初始化-②显示初始化/代码块中初始化-③构造器中初始化-
 * ④有了对象之后，可以“对象.属性”初始化
 */

public class SonTest {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.x);
    }
}

class Father{
    int x = 10;
    public Father(){
        this.print();
        x = 20;
    }
    public void print(){
        System.out.println("Father.x="+x);
    }
}

class Son extends Father{
    int x = 30;
    public Son(){
        this.print();
        x = 40;
    }
    public void print(){
        System.out.println("Son.x="+x);
    }
}
