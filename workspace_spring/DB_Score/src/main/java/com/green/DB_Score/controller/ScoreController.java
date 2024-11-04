package com.green.DB_Score.controller;

import com.green.DB_Score.service.ScoreService;
import com.green.DB_Score.service.ScoreServiceImpl;
import com.green.DB_Score.vo.StudentVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.lang.model.element.Name;
import java.util.List;

@Controller
public class ScoreController {

    @Resource(name = "scoreService")
    private ScoreServiceImpl scoreService; //


    //학생 목록 페이지
    @GetMapping("/")
    public String stuList(Model model){

        //학생 목록을 데이터 베이스에서 가져와야함...
        List<StudentVO> stuList = scoreService.getStuList();
        model.addAttribute("stuList", stuList);
        return "stu_list";
    }

    //학생등록페이지
    @GetMapping("/regForm")
    public String regForm(){
        return "reg_student";
    }


    //학생등록 + 학생목록 이동
    @PostMapping("/regStu")
    public String regStu(StudentVO studentVO){ //학생 데이터 받은거 가져가야하니까 넣어줘야함!
        scoreService.insertStudent(studentVO);
        return "redirect:/"; //목록페이지로 이동..
    }

    //상세페이지
    @GetMapping("/stuDetail")
    public String stuDetail(@RequestParam(name = "stuNum") int stuNum, Model model){

        //내가 클릭한 학생 한명을 DB에서 조회
         StudentVO student = scoreService.getStuDetail(stuNum);

        //학생 상세정보데이터를 html 전달!
        model.addAttribute("student", student);
        return "student_detail";
    }

    //삭제하기 + 이동
    @GetMapping("stuDelete")
    public String delete(@RequestParam(name = "stuNum")int stuNum, Model model){
        //학생삭제!?!?!?!
        scoreService.delete(stuNum);
        return "redirect:/";
    }

    //학생정보 수정페이지 이동
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam(name = "stuNum")int stuNum, Model model){

        //정보를 수정할 학생을 조회!
        StudentVO student = scoreService.getStuDetail(stuNum);
        model.addAttribute("student", student); //html 의 매개변수 전달.
        return "update_student";
    }

    //학생수정정보+상세페이지
    @PostMapping("/stuUpdate")
    public String stuUpdate(StudentVO studentVO){
        scoreService.stuUpdate(studentVO);

        return "redirect:/stuDetail?stuNum=" + studentVO.getStuNum();
    }







}
