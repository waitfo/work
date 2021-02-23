package com.cn.www.chapter01;

import java.util.ArrayList;
import java.util.List;

public class IntegerTest {
    public static void main(String[] args) {

        Integer x = 5;
        int y = 5;
        System.out.println(x==y);//true  自动拆箱

        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1==i2);//true
        //-128---127 调用Integer.valueOf()时，会判断是否在这个范围
        //如果在，则直接比较值，否则返回一个 new Integer(i)，所以上面是
        //true,下面是false

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3==i4);//false

        List<List> list = new ArrayList();
        for (int i=0;i<100000;i++){
            list.add(new ArrayList());
        }
    }
}
