package com.abin.lee.spring.boot.jpa.controller;

/**
 * Created by abin on 2018/1/15 19:48.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa.controller
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}