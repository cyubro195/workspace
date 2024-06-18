package com.green.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {


    //1. 자바에서 html로 데이터를 전달하기 위해서는
    //   실행되는 메서드의 매개변수의 Model 인터페이스 객체를 선언
    //2. 객체명.addAttribute메서드를 사용하여 데이터를 전달한다.

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("name","java");
        model.addAttribute("age",10);
        return "main";
    }

    @GetMapping("/login")
    public String login(Model model){

        String[] hobbies = {"독서","운동","공부"};
        model.addAttribute("abc",hobbies);

        Member m = new Member("집갈래",20,90);
        model.addAttribute("member",m);


        return "test_login";
    }

    @GetMapping("/join")
    public String join(Model model){

        List<Member> list = new ArrayList<>();

        Member m1 = new Member("최길동",20,90);
        Member m2 = new Member("김미현",23,40);
        Member m3 = new Member("강호둥",25,60);

        list.add(m1);
        list.add(m2);
        list.add(m3);

        model.addAttribute("memberList", list);

        return "test_join";
    }


}
