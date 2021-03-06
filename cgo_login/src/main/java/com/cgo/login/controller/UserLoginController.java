package com.cgo.login.controller;


import com.cgo.api.controller.login_module.IUserLoginController;
import com.cgo.api.pojo.login_module.LoginRequest;
import com.cgo.common.response.CommonCode;
import com.cgo.common.response.ResponseResult;
import com.cgo.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserLoginController implements IUserLoginController {

    @Autowired
    LoginService loginService;

    // 登录接口
    @RequestMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest loginRequest){
        ResponseResult responseResult = new ResponseResult();
        Map data=new HashMap();
        try {
            String access_token = loginService.login(loginRequest);
            data.put("access_token",access_token);
        }catch (Exception e){
            responseResult.setCommonRespones(CommonCode.FAIL);
            data.put("access_token","");
           log.error(" login_module error >>>  ",e);
        }
        responseResult.setData(data);
        return responseResult;
    }


    // 将jwt 转换为  用户信息 接口
    @RequestMapping("/userInfo")
    public ResponseResult userInfo(@RequestBody Map<String,String> map){
        ResponseResult responseResult =new ResponseResult();

        String access_token = map.get("access_token");
        Jwt decode = JwtHelper.decode(access_token);
        String data = decode.getClaims();

        responseResult.setData(data);

        return responseResult;
    }



}
