package com.abin.lee.spring.boot.jpa.service.impl;

/**
 * Created by abin on 2018/1/15 19:48.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa.service.impl
 * http://lib.csdn.net/article/javaee/2667
 */

import com.abin.lee.spring.boot.jpa.model.User;
import com.abin.lee.spring.boot.jpa.repository.UserRepository;
import com.abin.lee.spring.boot.jpa.service.UserService;
import com.abin.lee.spring.boot.jpa.util.PageUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll(Integer pageNum, Integer pageSize) {
        List<User> userList = null;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        userList = userPage.getContent();
        return userList;
    }


    @Override
    public List<User> findByAge(Integer pageNum, Integer pageSize, Integer age) {
        return userRepository.findByAge(age, PageUtil.pageSortAge(pageNum, pageSize, age));
    }


    public List<User> findByPage(Integer pageNum, Integer pageSize, Integer age, String userName) {
        List<User> userList = null;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<User> userPage = this.userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> userNamePath = root.get("userName");
                Path<Integer> agePath = root.get("age");
                List<Predicate> predicateList = Lists.newArrayList();
                if (!Strings.isNullOrEmpty(userName)) {
                    predicateList.add(criteriaBuilder.equal(userNamePath.as(String.class), userName));
                }
                if (null != age && age > 0) {
                    predicateList.add(criteriaBuilder.equal(agePath.as(Integer.class), age));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        }, pageable);
        userList = userPage.getContent();
        return userList;
    }

    public List<User> findByPaging(Integer pageNum, Integer pageSize, Integer age, String userName) {
        List<User> userList = null;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<User> userPage = this.userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> userNamePath = root.get("userName");
                Path<Integer> agePath = root.get("age");
                List<Predicate> predicateList = Lists.newArrayList();
                if (!Strings.isNullOrEmpty(userName)) {
                    predicateList.add(criteriaBuilder.equal(userNamePath.as(String.class), userName));
//                    predicateList.add(criteriaBuilder.like(userNamePath.as(String.class), "%"+userName+"%"));
                }
                if (null != age && age > 0) {
                    predicateList.add(criteriaBuilder.equal(agePath.as(Integer.class), age));
                }
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        }, pageable);
        userList = userPage.getContent();
        return userList;
    }


    public List<User> findByExamplePaging(Integer pageNum, Integer pageSize, Integer age, String userName) {
        List<User> userList = null;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);

        //创建查询条件数据对象
        User user = new User();
        user.setAge(age);
        user.setUserName(userName);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.exact())  //姓名采用“完全匹配，大小写敏感”的方式查询
                .withIgnorePaths("password")  //忽略属性：用户密码。因为是基本类型，需要忽略掉
                .withIgnorePaths("id");  //忽略属性：用户id。因为是基本类型，需要忽略掉

        Example<User> example = Example.of(user, matcher);

        Page<User> userPage = this.userRepository.findAll(example, pageable);
        userList = userPage.getContent();
        return userList;
    }





}
