package com.green.DataPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.lang.model.element.Name;

@Controller
public class ATagCotroller {

    @GetMapping("/a1")
    public String a1(Model model){
        model.addAttribute("stuName","kim");
        model.addAttribute("score",80);
        return "a1";
    }

    @GetMapping("/a2")
    //RequestParam 넘어오는 데이터의 이름이 네임???
    public String a2(@RequestParam(name = "address") String name){
        System.out.println("name = " + name);
        return "a2";
    }

    @GetMapping("/a3")
    public String a3(){

        return "a3";
    }



}
