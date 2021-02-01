package com.demo.cn;

import com.demo.cn.entity.Book;
import com.demo.cn.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test{

    @org.junit.Test
    public void test1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);

        Book book = new Book();
        book.setUserId(1221233113131L);
        book.setUsername("abc");
        book.setUstatus("hah");
        //bookService.addBook(book);

        System.out.println(bookService.findCount());
        System.out.println(bookService.findOne());
        System.out.println(bookService.findAll());
    }

    @org.junit.Test
    public void test2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3","name1","a"};
        Object[] o2 = {"4","c++","b"};
        Object[] o3 = {"5","mysql","c"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);

        bookService.batchAdd(batchArgs);
    }

    @org.junit.Test
    public void test3(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"name3","name1","3"};
        Object[] o2 = {"name4","c++","4"};
        Object[] o3 = {"name5","mysql","5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);

        bookService.batchUpdate(batchArgs);
    }
}