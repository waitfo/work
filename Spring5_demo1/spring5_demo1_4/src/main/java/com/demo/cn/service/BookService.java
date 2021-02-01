package com.demo.cn.service;

import com.demo.cn.dao.BookDao;
import com.demo.cn.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.addBook(book);
    }

    public int findCount(){
        return bookDao.findCount();
    }

    public Book findOne(){
        return bookDao.findOne(1221233113131L);
    }

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAdd(batchArgs);
    }

    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

}
