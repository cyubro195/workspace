package com.green.DataPractice.controller;

import com.green.DataPractice.vo.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {

    // localhost:8080/loginForm 으로 접속하면 실행!
    @GetMapping("/loginForm")
    public String loginForm(){
        return "login";
    }

    //form 태그로 전달되는 데이터를 받을 떄 매개변수를 사용한다.
    //매개변수에 @RequestParam 을 사용하여 데이터를 받을 수 있다.
    //@RequestParam(name = "이름")  : "이름" -> 전달되는 input 태그의 name 속성 값!
    @GetMapping("/login")
    public String login(@RequestParam(name = "id") String id, @RequestParam(name = "pw") String pw){
        System.out.println("id = " + id);
        System.out.println("pw = " + pw);
        return "login_result";
    }
/*
    html에서 전달되는 데이터의 이름(input 태그의 name속성값)과
    매개변수로 전달된 클래스의 멤버변수명이 일치하면
    html에서 넘어온 데이터를 객체에 자동 저장시켜 줌!
    이때 클래스는 반드시 getter, setter가 생성되어야 함.
    이렇게 html에서 넘어온 데이터를 받기 위해 컨트롤러안의 메서드에서
    매개변수로 활영하는 객체를 커맨드객체라고 지칭

*/
    //오타주의하소!!!!!!!!!!!!!!!틀리면 안된디야!!!!!!
    @PostMapping("/login1")
    public String login1(LoginVO loginVO, Model model){

        System.out.println("id = "+loginVO.getId());
        System.out.println("pw = "+loginVO.getPw());

        //html 대입
        model.addAttribute("loginInfo",loginVO);

        return "login_result";
    }




}
