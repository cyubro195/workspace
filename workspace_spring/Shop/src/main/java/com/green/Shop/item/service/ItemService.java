package com.green.Shop.item.service;

import com.green.Shop.item.vo.ItemVO;

import java.util.List;

public interface ItemService {

    //상품목록조회
    List<ItemVO> getItemList();

    //상품 상세조회
    ItemVO getItemDetail(int itemCode);
}
