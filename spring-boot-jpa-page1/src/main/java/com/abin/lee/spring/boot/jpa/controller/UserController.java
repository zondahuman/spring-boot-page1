package com.abin.lee.spring.boot.jpa.controller;

/**
 * Created by abin on 2018/1/15 19:48.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa.controller
 */

import com.abin.lee.spring.boot.jpa.model.User;
import com.abin.lee.spring.boot.jpa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }




    @RequestMapping("/add1")
    @ResponseBody
    public String add1(@ModelAttribute User user) {
        userService.save(user);
        return "SUCCESS";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(Integer pageNum, Integer pageSize) {
        List<User> users = userService.findAll(pageNum, pageSize);
        return users;
    }

    @RequestMapping("/findByAge")
    @ResponseBody
    public List<User> findByAge(Integer pageNum, Integer pageSize, Integer age) {
        List<User> users = userService.findByAge(pageNum, pageSize, age);
        return users;
    }

    @RequestMapping("/findByPage")
    @ResponseBody
    public List<User> findByPage(Integer pageNum, Integer pageSize, Integer age, String userName) {
        List<User> users = userService.findByPage(pageNum, pageSize, age, userName);
        return users;
    }

    @RequestMapping("/findByPaging")
    @ResponseBody
    public List<User> findByPaging(Integer pageNum, Integer pageSize, Integer age, String userName) {
        List<User> users = userService.findByPaging(pageNum, pageSize, age, userName);
        return users;
    }

    @RequestMapping("/findByExamplePaging")
    @ResponseBody
    public List<User> findByExamplePaging(Integer pageNum, Integer pageSize, Integer age, String userName) {
        List<User> users = userService.findByExamplePaging(pageNum, pageSize, age, userName);
        return users;
    }







}