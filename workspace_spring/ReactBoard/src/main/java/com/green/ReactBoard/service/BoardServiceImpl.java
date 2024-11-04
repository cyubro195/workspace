package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLPermission;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    //게시글 목록조회
    @Override
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList =  sqlSession.selectList("boardMapper.getBoardList");
        return boardList;
    }

    //게시글 상세조회
    @Override
    public BoardVO getBoardDetail(int boardNum) {
        return sqlSession.selectOne("boardMapper.getBoardDetail", boardNum);
    }

    //게시글 등록
    @Override
    public void regBoard(BoardVO boardVO) {
        sqlSession.insert("boardMapper.regBoard", boardVO); // << 빈값채워줄애 넣으셈!
                                        // ▲ 들어가야할 id를 넣어주셈
    }

    @Override
    public void boardDelete(int boardNum) {
        sqlSession.delete("boardMapper.boardDelete", boardNum);
    }


}
