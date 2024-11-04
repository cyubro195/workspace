package com.green.BasicBoard.controller;

import com.green.BasicBoard.service.BoardService;
import com.green.BasicBoard.service.BoardServiceImpl;
import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Resource(name = "boardService")
    private BoardService boardService;


    //게시판 목록 페이지
    @RequestMapping("/") //애는 getmapping + postmapping 둘 다 허용해줌
    public String list(Model model, SearchVO searchVO){
                                    // ▲데이터를 받기위해서 만듬▲
        //SearchVO 검색 데이터 검사
        System.out.println(searchVO);

        //목록조회
        List<BoardVO> boardList = boardService.getBoardList(searchVO);
        model.addAttribute("boardList", boardList);
        return "board_list";
    }

    //게시판등록
    @GetMapping("/insertForm")
    public String insertForm(){

        return "write_form";
    }

    //게시판 등록 + 학생목록
    @PostMapping("/insertBoard")
    public String insertBoard(BoardVO boardVO){
        boardService.insertBoard(boardVO);
        return "redirect:/";
    }

    //게시판 상세조회
    @GetMapping("/detailBoard")
    public String detailBoard(@RequestParam(name = "boardNum")int boardNum,Model model){

        // BoardVO board = boardService.detailBoard(boardNum); 다른버전 둘다 답 똑같음
        model.addAttribute("board", boardService.detailBoard(boardNum));

        //조회수 증가
        boardService.updateReadCnt(boardNum);
        return "board_detail";
    }


    //삭제하기 + 이동
    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam(name = "boardNum")int boardNum){
        boardService.deleteBoard(boardNum);

        return "redirect:/";
    }


    //게시판 수정하기
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam(name = "boardNum")int boardNum, Model model){

        BoardVO board = boardService.detailBoard(boardNum);
        model.addAttribute("board",board);
        return "update_form";
    }

    //게시판 수정정보 + 상세페이지
//    @PostMapping("boardUpdate")
//    public String boardUpdate(){
//    }
//

}
