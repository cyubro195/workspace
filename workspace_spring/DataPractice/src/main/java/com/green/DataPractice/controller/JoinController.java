package com.green.DataPractice.controller;

import com.green.DataPractice.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @GetMapping("/reg")
    public String regMember(){
        return "reg_member";
    }

    //커맨드 객체는 model을 사용하지 않아도 자동으로 html로 전달된다.
    //이때 넘어가는 데이터는 클래스명에서 앞글자만 소문자로 바꾼 이름으로 넘어간다!

    @PostMapping("/result")
    public String result(MemberVO memberVO){
        System.out.println(memberVO);
        return "member_info";
    }

    @GetMapping("/survey")
    public String survey(){
        return "survey";
    }

    @PostMapping("sResult")
    public String sResult(){
        return "survey_result";
    }






}
