package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.service.BoardServiceImpl;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.PageVO;
import com.green.Board.vo.SearchVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {
    @Resource(name = "boardService")
    private BoardService boardService;

    //게시글 목록 조회
    @PostMapping("/list")
        /* 넘어오는 데이터가 있으면 받고 넘어오는게 없으면 안받는 애 ▼ */

    public Map<String, Object> getBoardList(@RequestBody(required = false) SearchVO searchVO){

        log.info ("=======넘어온 페이지=======" + searchVO.getPageNo());

        //전체 게시글 수 조회
        int totalDataCnt = boardService.getBoardCnt();

        // 페이지 정보를 담을 수 있는 PageVO 객체생성
        PageVO pageInfo = new PageVO(totalDataCnt);

        if(searchVO.getPageNo() != 0){
            pageInfo.setNowPage(searchVO.getPageNo());
        }

        pageInfo.setPageInfo();

        System.out.println(pageInfo);

        // 게시글 목록 데이터
        List<BoardVO> boardList = boardService.getBoardList(pageInfo);

        //리액트로 가져갈 모든 데이터를 담을 변수
        Map<String, Object> mapData = new HashMap<>();
        mapData.put("pageInfo", pageInfo);
            // 가져갈 데이터의 이름 ▲

        // 게시글 목록 데이터
        mapData.put("boardList",boardList);

        return mapData;

    }

    //게시글 등록
    @PostMapping("/insert")
                            /* ▽ 리액트에서 넘어오는 파일 받을때는 이친구 써줘야함!*/
    public void insertBoard(@RequestBody BoardVO boardVO){
        log.info(" ======= BoardController : insertBoard() run~ ========== ");
        log.info(boardVO.toString());
        boardService.insertBoard(boardVO);
    }

    //게시글 상세 조회
    @GetMapping("/detail/{boardNum}")
    public BoardVO boardDetail(@PathVariable("boardNum") int boardNum){
        return boardService.getBoardDetail(boardNum);
    }

    //게시글 삭제
    @DeleteMapping("/delete/{boardNum}")
    public void deleteBoard(@PathVariable("boardNum") int boardNum){

        boardService.deleteBoard(boardNum);
    }

    //게시글수정
    @PutMapping("/update")
    public void updateBoard(@RequestBody BoardVO boardVO){
        boardService.updateBoard(boardVO);
    };




}
