package com.demo.cn.dao;

import com.demo.cn.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public int findCount() {
        String sql = "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public Book findOne(Long id) {
        String sql = "select * from t_book where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from t_book";
        List<Book> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));

        return list;
    }

    @Override
    public void batchAdd(List<Object[]> btchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,btchArgs);
        System.out.println(ints);
    }

    @Override
    public void batchUpdate(List<Object[]> btchArgs) {
        String sql = "update t_book set username=?,ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, btchArgs);

        System.out.println(ints);

    }


}
