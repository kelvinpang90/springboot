package com.pwk.springboot.dao;

import com.pwk.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserDao {
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "username", column = "username",javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class)
    })
    List<User> getAllUsers();

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void addUser(User user);
}
