package com.green.ReactStudent.controller;

import com.green.ReactStudent.service.StudentService;
import com.green.ReactStudent.vo.StudentVO;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Resource(name = "StudentService")
    private StudentService studentService;


    //학생리스트 목록조회
    @GetMapping("/stuList")
    public List<StudentVO> stuList(){
        System.out.println(studentService.getStuList());
       return studentService.getStuList();

    }

    //학생등록
    @PostMapping("/insertStu")
    public void insertStu(@RequestBody StudentVO studentVO){
        studentService.insertStu(studentVO); //<빈값채워직
    }

    //학생상세
    @GetMapping("/stuDetail/{stuNum}")
    public StudentVO stuDetail(@PathVariable("stuNum")int stuNum){
        System.out.println(stuNum);
        return studentService.stuDetail(stuNum);
    }

    //학생삭제
    @DeleteMapping("/stuDelete/{stuNum}")
    public void stuDelete(@PathVariable("stuNum") int stuNum){
        studentService.stuDelete(stuNum);
    }

    //학생수정
    @PutMapping("/stuUpdate")
    public void stuUpdate(@RequestBody StudentVO studentVO){
        studentService.stuUpdate(studentVO);
    }
}
