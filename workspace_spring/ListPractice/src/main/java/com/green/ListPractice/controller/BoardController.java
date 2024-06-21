package com.green.ListPractice.controller;


import com.green.ListPractice.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    //게시글 목록을 저장할 리스트 생성
    List<BoardVO> boardList = new ArrayList<>();

    //게시글 목록 페이지로 이동
    @GetMapping("/list")
    public String boardList(Model model){
        //게시글 목록 데이터를 html 전달
        model.addAttribute("boardList",boardList);
        return "board_list";
    }

    @GetMapping("/writeForm")
    public String writeForm(BoardVO boardVO){
        return "board_writeForm";
    }

    //작성한 내용으로 글 등록하기
    @PostMapping("/regBoard")
    public String regBoard(BoardVO boardVO){
        System.out.println(boardVO);

        //글등록
        boardList.add(boardVO);

        //return에는 원래 이동할 html 파일명 작성
        //redirect: -> 컨트롤러로 이동하겠다.
        return "redirect:/list"; // < 이거 자주씀!

    }

    //게시글 목록페이지에서 제목 클릭시 상세페이지로 이동하기.
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "boardNum")int boardNum, Model model){
        //내가 클릭한 게시글의 상세정보를 html에 뿌려주고 싶응!
        //1. 내가 클릭한 게시글을 어떻게 구분하냐!? => 글번호로  구분하면됨!
        // - 내가 클릭한 게시글의 글번호를 알아야함!
        // - 게시글 목록(boardList)에서 내가 가지고 온 글번호와 일치하는 게시글을 찾음
            BoardVO result = null; //빈값으로 초기화해놓기
            for (BoardVO board : boardList){
                if (board.getBoardNum() == boardNum) {
                    result = board;
                }
            }
        //2. 내가 찾은 게시글을 html에 데이터 전달
        model.addAttribute("board",result); //result의 안에는 내가 찾는 글번호를 가지고 있음


        //html에 데이터 전달!
        return "board_detail";
    }
    //게시글 삭제 > 게시글 목록페이지로 이동
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "boardNum")int boardNum){

        int deleteIndex = 0; //삭제할 게시글

        for (int i =0; i<boardList.size(); i++){
            if (boardList.get(i).getBoardNum() == boardNum){
                deleteIndex = i;
            }
        }
        boardList.remove(deleteIndex);
        // boardList.remove(1); 삭제할때 첫번째 삭제하겠다라는 뜼. boardNum이랑은 상관없음
        return "redirect:/list";
    }


}
