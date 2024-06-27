package com.green.DB_Score.controller;

import com.green.DB_Score.service.ScoreService;
import com.green.DB_Score.service.ScoreServiceImpl;
import com.green.DB_Score.vo.StudentVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ScoreController {

    @Resource(name = "scoreService")
    private ScoreServiceImpl scoreService; //


    //학생 목록 페이지
    @GetMapping("/")
    public String studentList(Model model){

        //학생 목록을 데이터 베이스에서 가져와야함...
        List<StudentVO> stuList = scoreService.getStuList();
        model.addAttribute("stuList", stuList);
        return "stu_list";
    }



}
