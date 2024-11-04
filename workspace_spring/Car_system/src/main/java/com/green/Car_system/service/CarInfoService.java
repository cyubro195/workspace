package com.green.Car_system.service;

import com.green.Car_system.vo.CarInfoVO;

import java.util.List;

public interface CarInfoService {

    //자동차 목록조회
    List<CarInfoVO> carList();

    //자동차 등록
    void insertCar(CarInfoVO carInfoVO);

    //차량모델 조회
    List<CarInfoVO> getCarModelList();
}
