package com.demo.cn;

import com.demo.cn.entity.Book;
import com.demo.cn.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        bookService.addBook(book);
    }
}