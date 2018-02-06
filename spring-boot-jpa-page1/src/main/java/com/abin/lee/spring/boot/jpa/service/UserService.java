package com.abin.lee.spring.boot.jpa.service;

/**
 * Created by abin on 2018/1/15 19:47.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa.service
 */

import com.abin.lee.spring.boot.jpa.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User findUserById(long id);

    void save(User user);

    void edit(User user);

    void delete(long id);

    List<User> findAll(Integer pageNum, Integer pageSize);

    List<User> findByAge(Integer pageNum, Integer pageSize, Integer age);

    List<User> findByPage(Integer pageNum, Integer pageSize, Integer age, String userName);

    List<User> findByPaging(Integer pageNum, Integer pageSize, Integer age, String userName);





}
