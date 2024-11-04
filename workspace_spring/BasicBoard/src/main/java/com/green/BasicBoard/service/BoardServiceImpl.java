package com.green.BasicBoard.service;

import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    //게시글 목록조회
    @Override
    public List<BoardVO> getBoardList(SearchVO searchVO) {
        //List<BoardVO> list = sqlSession.selectList("boardMapper.getBoardList", ??? ); 두번째 매개변수는 빈 값 채울 때 필요함.
        //return list;
        return sqlSession.selectList("boardMapper.getBoardList", searchVO);

    }

    @Override
    public void insertBoard(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insertBoard", boardVO);
    }


    //상세조회
    @Override
    public BoardVO detailBoard(int boardNum) {
    //BoardVO board = sqlSession.selectOne("boardMapper.detailBoard", boardNum);
        return sqlSession.selectOne("boardMapper.detailBoard", boardNum);
    }

    //게시글 삭제
    @Override
    public void deleteBoard(int boardNum) {
        sqlSession.delete("boardMapper.deleteBoard",boardNum);
    }

    //업데이트(조회수 증가)
    @Override
    public void updateReadCnt(int boardNum) {
        sqlSession.update("boardMapper.updateReadCnt",boardNum);
    }

}
