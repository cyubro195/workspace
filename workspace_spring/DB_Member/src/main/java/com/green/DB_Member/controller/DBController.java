package com.green.DB_Member.controller;

import com.green.DB_Member.service.DBService;
import com.green.DB_Member.service.DBServiceImpl;
import com.green.DB_Member.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//오늘은 신나는 DBDAY...
@Controller
public class DBController {

    //객체를 직접 생성하지않음! new = 어쩌구 안함! 가져와서 넣어주셈
    @Resource(name = "dbService")
    private DBServiceImpl dbService;

    //회원번호가 1번인 회원의 이름을 조회
    @GetMapping("select1")
    public String select1(){
        String name = dbService.select1(); //객체불러오기.지정하기;
        System.out.println("조회한 이름 : " + name);
        return "db_result";
    }

    //전달된 회원번호를 지닌 회원의 나이를 조회!
    @GetMapping("/select2")
    public String select2(){
        int age = dbService.select2(5);//회원 나이조회하게 번호 쓰셈
        System.out.println("조회한 나이 : " + age);
        return "db_result";
    }

    //전달받은 나이이상의 회원 이름을 조회!
    @GetMapping("/select3")
    public String select3(){
        List<String> nameList = dbService.select3(40); // 나이가 40살이상 조회하기
        for ( String name : nameList){
            System.out.println("조회된 이름 : " + name);
        }
        return "db_result";
    }

    //전달받은 회원번호를 지닌 회원의 회원번호,이름,나이,주소 조회
    @GetMapping("/select4")
    public String select4(){
        MemberVO member = dbService.select4(23);
        System.out.println(member);
        return "db_result";
    }


    //모든 회원의 회원번호,이름,나이,주소를 조회
    @GetMapping("/select5")
    public String select5(){
        List<MemberVO> memberList = dbService.select5();
        for ( MemberVO member: memberList){
            System.out.println(member);
        }
        return "db_result";
    }


    //전달받은 회원번호를 가진 회원을 삭제하기
    @GetMapping("/delete")
    public String delete(){
        int result = dbService.delete(2);
        System.out.println("삭제 : " + result);
        return "db_result";
    }

    //회원한명추가
    @GetMapping("/insert")
    public String insert(){
        MemberVO vo = new MemberVO();
        vo.setMemNum(987);
        vo.setMemName("최뚝심");
        vo.setMemAge(30);
        vo.setMemAddr("김해시");

        dbService.insert(vo); //리턴 보이드로 만들어서 전달되는거 없음!!!!그냥하면됨ㅎ

        return "db_result";
    }

    //전달받은 회원번호를 지닌 회원의 이름,나이,주소를 변경하는
    @GetMapping("/update")
    public String update(){
        MemberVO vo = new MemberVO();
        vo.setMemNum(10);
        vo.setMemName("김복순");
        vo.setMemAge(56);
        vo.setMemAddr("충주시");

        int result = dbService.update(vo);
        System.out.println("업데이트 개수 : " + result);

        return "db_result";
    }


}
