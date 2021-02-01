package com.demo.cn.dao;

import com.demo.cn.entity.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    int findCount();

    Book findOne(Long id);

    List<Book> findAll();

    void batchAdd(List<Object[]> btchArgs);

    void batchUpdate(List<Object[]> btchArgs);


}
