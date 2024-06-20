package com.green.DataPractice.controller;

import com.green.DataPractice.vo.ScoreVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScoreController {

    @GetMapping("/a")
    public String inputName(){
        return "input_name";
    }

    @PostMapping("/b")
    public String inputAge(@RequestParam(name = "name")String name, Model model){
        System.out.println(name);
        model.addAttribute("name",name);
        return "input_age";
    }

    @PostMapping("/c")
    public String show(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age){
        return "show";
    }

    //시작페이지 이동
    @GetMapping("/sgp")
    public String sgp(){ //애는 안줘드댐 시작페이지라서!
        return "sgp";
    }

    //첫번째 페이지에서 넘어온 데이터를 받아, 두번째 페이지로 이동
    @PostMapping("/sgp_sub1")
    public String spgSub1(ScoreVO scoreVO){//커멘드 객체는 model안만들어드댐!
        System.out.println(scoreVO);
        return "sgp_sub1";
    }

    //세번째 페이지로 이동
    @PostMapping("/sgp_sub2")
    public String spgSub2(ScoreVO scoreVO){
        System.out.println(scoreVO);
        return "sgp_sub2";
    }

    //네번째 페이지 이동
    @PostMapping("/sgp_sub3")
    public String spgSub3(ScoreVO scoreVO, Model model){
        System.out.println(scoreVO);

        //평균구하기
        double avg = (scoreVO.getKorscore() + scoreVO.getEngscore() + scoreVO.getMathscore() ) / 3.0;
        model.addAttribute("avg");

        return "sgp_sub3";

    }


}
