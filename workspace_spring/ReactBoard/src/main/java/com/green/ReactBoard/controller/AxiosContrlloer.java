package com.green.ReactBoard.controller;

import com.green.ReactBoard.service.AxiosService;
import com.green.ReactBoard.vo.BoardVO;
import com.green.ReactBoard.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AxiosContrlloer {
    @Resource(name = "axiosService")
    private AxiosService axiosService;

    //1번버튼 클릭 시 호출되는 메서드
    @GetMapping("/getList")
    public List<BoardVO> getList(){
        return axiosService.getList();
    }
    @PostMapping("/insertBoard")
    public void insertBoard(@RequestBody MemberVO memberVO){
        System.out.println(1);
        System.out.println(memberVO);
    }

    @PutMapping("/updateBoard")
    public int updateBoard(@RequestBody BoardVO boardVO){
                            // ▲ post, get 으로 받을 때는 이친구
        System.out.println(boardVO);
        //데이터베이스 update 쿼리실행
        return 10;
    }


    @GetMapping("/detail/{boardNum}")  // < 변수를 넘기겠돠!
                        // ▼ 여기로 받아서              ▼ 여기로 넘겨주겠다
    public void detail(@PathVariable("boardNum")int boardNum){
                        // ▲ 리퀘스트 파란이랑 비슷한애임
        System.out.println(boardNum);


    }
}
