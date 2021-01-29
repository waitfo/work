package com.demo.cn.dao;

import com.demo.cn.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addBook(Book book) {
        //1.创建sql语句
        String sql = "insert into t_book values(?,?,?)";
        Object[] args = {book.getUserId(),book.getUsername(),book.getUstatus()};
        //这样也可以
        //int update = jdbcTemplate.update(sql,args);
        int update = jdbcTemplate.update(sql,book.getUserId(),book.getUsername(),book.getUstatus());
        System.out.println(update);
    }
}
