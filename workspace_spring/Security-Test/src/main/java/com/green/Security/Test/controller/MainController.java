package com.green.Security.Test.controller;

import com.green.Security.Test.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    // 필드 주입
    @Resource(name = "memberService")
    private MemberService memberService;

    //로그인 페이지로 이동
    @GetMapping("/")
    public String main(){
        return "main is running~";
    }

    //회원가입 페이지로 이동
    @GetMapping("/test")
    public String test(){
        return "되냐고~~~~";
    }
}
