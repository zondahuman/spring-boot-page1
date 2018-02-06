package com.abin.lee.spring.boot.jpa.service;

/**
 * Created by abin on 2018/1/15 19:47.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa.service
 */

import com.abin.lee.spring.boot.jpa.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

    List<User> findAll(Integer pageNum, Integer pageSize);

    List<User> findByAge(Integer pageNum, Integer pageSize, Integer age);

}
