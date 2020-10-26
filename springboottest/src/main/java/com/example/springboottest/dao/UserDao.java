package com.example.springboottest.dao;

import com.example.springboottest.entiy.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert({
            "insert into user(id,name,mobile,email)",
            "value(#{id},#{name},#{mobile},#{email})"
    })
    int insert(User test);

    @Delete({
            "delete",
            "from user",
            "where id=#{id}"
    })
    int delete(int id);

    void update(User user);

    @Select({
            "select id,name,mobile,email",
            "from user"
    })
    List<User> findAll();

    @Select({ "select id,name,mobile,email",
            "from user ",
            "where id = #{id}" })
    User findOne(int id);
}
