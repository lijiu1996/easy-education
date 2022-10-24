package com.lijiawei.education.serviceedu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户登录接口
 */
@RestController
@RequestMapping("/eduservice/entry")
public class EduLoginController {

    @PostMapping("login")
    public void login() {

    }

    @PostMapping("info")
    public void info() {

    }
}
