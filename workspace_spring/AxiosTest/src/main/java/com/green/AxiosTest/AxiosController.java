package com.green.AxiosTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController : 컨트롤러 안의 메서드 리턴이 html 파일명이 아니다!
@RestController //리액트 쓸때는 이친구를 켜줘야함!
public class AxiosController {

    @GetMapping("/test1")
    public String test1(){
        return " 로또 당첨되고싶다 집에도 가고싶다 ";
        // 이렇게하면 html 없이도 그대로 화면에 글자가 나타남! 신귀방귀~
    }

    @GetMapping("/test2")
    public int test2(){
        return 100;

    }

    @GetMapping("/test3")
    public int[] test3(){
        int[] arr = {1,2,3,4,5};
        return arr;
    }

    @GetMapping("/test4")
    public List<ItemVO> test4(){ //기억해 리턴자료가 'void'면 리턴 필요없어!
        //ItemVO 객체를 세 개 리액트로 전달 시키쉠
        ItemVO item1 =new ItemVO( 1,"처음 만나는 자바",32900,"소개1","book_2.jpg" );
        ItemVO item2 =new ItemVO( 2,"디자인 패턴",23900,"소개2","book_1.jpg" );
        ItemVO item3 =new ItemVO( 3,"모두의 딥러닝",25900,"소개3","book_3.jpg" );

        List<ItemVO> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        return itemList;

    }

}
