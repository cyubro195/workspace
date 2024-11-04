package com.green.BasicBoard.service;


import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;

import java.util.List;

public interface BoardService {


    //게시글 목록 조회
    List<BoardVO> getBoardList(SearchVO searchVO);

    //게시글 등록
    void insertBoard(BoardVO boardVO);

    //게시글 상세조회
    BoardVO detailBoard(int boardNum);

    //게시글 삭제
    void deleteBoard(int boardNum);

    //조회수 증가
    void updateReadCnt(int boardNum);

    //게시글 수정








}
