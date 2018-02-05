package com.abin.lee.spring.boot.jpa.repository;

/**
 * Created by abin on 2018/1/15 19:46.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa
 */
import com.abin.lee.spring.boot.jpa.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    Long deleteById(Long id);

    List<User> findByAge(int age, Pageable pageable);
}