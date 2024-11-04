package com.green.Board.vo;

import lombok.Data;

@Data
public class SearchVO {
    private String searchType; // ◀ 이거 자체가 null
    private String searchValue;
    private int pageNo;
}
