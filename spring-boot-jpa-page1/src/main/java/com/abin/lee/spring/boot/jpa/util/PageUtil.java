package com.abin.lee.spring.boot.jpa.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by abin on 2018/2/5 18:43.
 * spring-boot-jpa-thymeleaf
 * com.abin.lee.spring.boot.jpa.util
 */
public class PageUtil {


    public static Pageable defaultPage() {
        return new PageRequest(0, 10);
    }

    public static Pageable pageSortId() {
        return new PageRequest(1, 10, Sort.Direction.ASC, "id");
    }

    public static Pageable pageSortIdAndAge() {
        return new PageRequest(1, 10, Sort.Direction.ASC, "id", "age");
    }

    public static Pageable createPageRequest() {
        return new PageRequest(1,
                10,
                new Sort(Sort.Direction.DESC, "id")
                        .and(new Sort(Sort.Direction.ASC, "age"))
        );
    }


}
