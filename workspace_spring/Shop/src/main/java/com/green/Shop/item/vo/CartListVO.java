package com.green.Shop.item.vo;

import lombok.Data;

@Data
public class CartListVO {
    private int cartCode;
    private int itemCode;
    private int cartCnt;
    private String memId;
    private String cartDate;
}
