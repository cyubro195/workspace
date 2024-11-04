package com.green.Board.vo;


import lombok.Data;

// 페이지 처리를 위한 모든 정보를 갖는 클래스
// 페이지네이션 구현
@Data
public class PageVO {

    //전체 데이터(페이지) 수
    private int totalDataCnt;

    //한 페이지에 보여지는 데이터(게시글) 수
    private int displayDataCnt;

    //전체 페이지 수
    private int totalPageCnt;

    //현재 페이지
    private int nowPage;

    //한 화면에 보여지는 페이지 수
    private int displayPageCnt;
    
    //화면에 보이는 시작 페이지
    private int beginPage;
    
    //화면에 보이는 미자막 페이지
    private int endPage;
    
    //이전 버튼 유무
    private boolean prev;

    //다음 버튼 유무
    private boolean next;

    //조회 쿼리에서 OFFSET 을 들어갈 데이터
    private int offset;

    //생성자 : 객체가 생성될때
    // 매개변수 : 디비에서 조회환 전체 데이터 수
    public PageVO(int totalDataCnt){
        nowPage = 1;
        // 한 화면에 몇개(게시글)를 보여줄지 변수를 선언하는거!
        // ▼ 1 2 3 4 5 next << 이런식으로 세팅한다는 뜻!
        displayPageCnt = 5; // 게시글 넘버 1,2,3,4,5 까지 나온다.
        displayDataCnt = 10; // 게시글 10개로 보겠습니다.
        this.totalDataCnt = totalDataCnt;


    }
    //모든 페이지 정보를 세팅하는 메서드
    public void setPageInfo(){
        // 총 게시글 수 => totalDataCnt 20
        // 현재 페이지 => nowPage 1
        // 한 화면에 보이는 페이지 수 => displayPageCnt

        // 화면에 보이는 마지막 페이지 번호
        endPage = (int)Math.ceil(nowPage/(double)displayPageCnt) * displayPageCnt;

        //화면에 보이는 시작 페이지 번호
        beginPage = endPage - displayPageCnt + 1;

        //전체 페이지 수
        totalPageCnt = (int)Math.ceil(totalDataCnt/(double)displayDataCnt);
                       // ▲ 실수를 정수로 바꿔줘야하니까 앞에 int 넣어주기!

        if (endPage > totalPageCnt) {
            endPage = totalPageCnt;
        }

        // endPage = endPage > totalPageCnt ? totalPageCnt : endPage;
        // ▲ 이렇게도 되긴하는디 억텐 (?)

        // 이전 버튼 유무
        prev = beginPage != 1;

        // 다음 버튼 유무
        next = endPage != totalPageCnt; // 15 != 15 : false

        offset = displayDataCnt * (nowPage - 1 );

    }


}
