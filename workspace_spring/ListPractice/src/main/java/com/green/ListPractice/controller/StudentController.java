package com.green.ListPractice.controller;

import com.green.ListPractice.service.StudentService;
import com.green.ListPractice.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    StudentService studentService = new StudentService();

    //학생목록페이지
    @GetMapping("/")
    public String stuList(Model model){

        //학생 목록 데이터 받아오기
        List<StudentVO> list = studentService.getStuList(); //학생목록을 리턴해줌
        //우측에 있는 값을 저장합니다. 라는 뜻

        //학생목록을 html로 전달
        model.addAttribute("stuList", list);
        return "stu_list";
    }

    //학생 등록 페이지

    //post는 form만! 나머지 전부 get
    @GetMapping("/regForm")
    public String regForm(){
        return "reg_student";
    }

    //학생 등록 + 학생 목록페이지로 이동
    @PostMapping("/regStu")
                        //입력한 학생의 모든정보가 담겨있음
    public String regStu(StudentVO studentVO){

        studentService.regStudent(studentVO);
        return "redirect:/";
        //html 파일로 가는게 아니라 컨트롤러에 있는 페이지로 넘어간다는뜻.
    }


    //상세페이지
    @GetMapping("/stuDetail")
    public String stuDetail(@RequestParam(name = "year") int year,Model model){

        //내가 클릭한 학생 한명을 검색(학번을 알면 됨)
        StudentVO student = studentService.getStuDetail(year);
        // 서비스 클래스에서 자세히 만듬.

        //학생 상세정보데이터를 html 전달!
        model.addAttribute("student", student);
        return "student_detail";
    }

    //학생리스트 삭제하기 + 목로페이지로 이동
    @GetMapping("/stuDelete")
    public String delete(@RequestParam(name = "year")int year, Model model){

        //학생삭제
        studentService.deleteStu(year);
        model.addAttribute("student", year);

        return "redirect:/"; //목록페이지로 이동
    }

    //학생정보 수정페이징
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam(name = "year")int year, Model model){
        //가져갈 데이터가 있는가 ? 생각하세요!

        //정보를 수정할 학생의 원래 정보를 HTML 전달!
        //1. 정보를 수정할 학생 한명을 선택할 수 있어야한다!
       StudentVO student =  studentService.getStuDetail(year);
        //학생상세보기할때 참고!, 서비스패키지 참조하깅!

        //2. 수정할 학생을 html 전달
        model.addAttribute("student",student);
        return "update_student"; //수정페이지로 이동
    }

    //학생정보수정 + 상세페이지로 이동!
    @PostMapping("/updateStu")
    public String updateStu(StudentVO studentVO){

        //학생 정보 수정
        studentService.updateStu(studentVO);
        return "redirect:/stuDetail?year=" + studentVO.getYear();

    }

}
