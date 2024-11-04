package com.green.Car_system.service;

import com.green.Car_system.vo.Sales_InfoVO;

import java.util.List;

public interface SalesInfoService {

    //구매자 목록조회
    List<Sales_InfoVO> getBuyList();

    //구매자 등록
    void insertSales(Sales_InfoVO sales_infoV);
}
