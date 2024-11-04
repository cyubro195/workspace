package com.green.Shop.cart.vo;

import com.green.Shop.item.vo.ItemVO;
import lombok.Data;

import java.util.List;

@Data
public class CartVO {
    private int cartCode;
    private int itemCode;
    private int cartCnt;
    private String memId;
    private String cartDate;
    private ItemVO itemVO;
    /*이미지를 여러개 받아야하기 때문에??*/
}
