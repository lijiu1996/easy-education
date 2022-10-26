package com.lijiawei.education.serviceedu.controller;

import com.lijiawei.education.serviceedu.entity.vo.LoginVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户登录接口
 */
@RestController
@RequestMapping("/service_edu/account")
public class EduLoginController {

    @PostMapping("login")
    public void login(@RequestBody LoginVO loginVO) {

    }

    @PostMapping("info")
    public void info() {

    }
}
