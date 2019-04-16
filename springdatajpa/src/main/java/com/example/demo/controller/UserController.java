package com.example.demo.controller;

import java.util.Objects;
import java.util.Optional;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.QUser;
import com.example.demo.entity.User;
import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * 目前service和controller合并   为了简化 下 不规范
 *
 */
@RestController
@RequestMapping("users")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private QUser qUser=QUser.user;
    @GetMapping("")
    public void get(){
        User user=new User();
        user.setName("测试 啊 ");
        System.out.println(userRepository.save(user));
    }
    // 修改页面
    @GetMapping("/search")
    @ResponseBody
    public Page<User> search(
            @RequestParam(value = "name", required = false) String name,
            @PageableDefault Pageable pageable) {

        BooleanBuilder query = new BooleanBuilder();
        if (!Objects.isNull(name)) {
            query.and(qUser.name.containsIgnoreCase(name).and(qUser.name.like("a")));
        }
        Page<User> users = userRepository.findAll(query.getValue(),pageable);

        return users;
    }
}
