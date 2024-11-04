package com.green.Car_system.vo;

import lombok.Data;

import java.util.List;

@Data
public class Sales_InfoVO {
    private int salesNum;
    private String buyer;
    private int buyerTel;
    private String color;
    private String buyDate;
    private int carNum;
    private List<CarInfoVO> carInfo;
}
