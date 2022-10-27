package com.lijiawei.education.serviceedu.controller;

import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceedu.entity.dto.LoginDTO;
import com.lijiawei.education.serviceedu.entity.dto.UserInfoDTO;
import com.lijiawei.education.serviceedu.entity.vo.InfoVO;
import com.lijiawei.education.serviceedu.entity.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 *  用户登录接口
 */
@Slf4j
@Api(tags = "登录管理")
@RestController
@RequestMapping("/service_edu/account")
@CrossOrigin
@UnionResponse
public class EduLoginController {

    @ApiOperation("登录")
    @PostMapping("login")
    public LoginDTO login(@RequestBody LoginVO loginVO) {
        if ("admin".equals(loginVO.getUsername()) &&
            "123456".equals(loginVO.getPassword()))
            return new LoginDTO("admin");
        return null;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("info")
    public UserInfoDTO info(String token) {
        return new UserInfoDTO("admin","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    @ApiOperation("退出登录")
    @PostMapping("logout")
    public void logOut() {
        log.info("用户{}退出登录","aaa");
        return ;
    }
}
