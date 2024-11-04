package com.green.Car_system.controller;

import com.green.Car_system.service.CarInfoService;
import com.green.Car_system.vo.CarInfoVO;
import com.green.Car_system.vo.Sales_InfoVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_car")
public class CarInfoController {
    @Resource(name = "carInfoService")
    private CarInfoService carInfoService;

    //자동차 목록조회
    @GetMapping("carList")
    public List<CarInfoVO> carList(){
        return carInfoService.carList();
    }

    //자동차 등록
    @PostMapping("insertCar")
    public void insertCar(@RequestBody CarInfoVO carInfoVO){
        carInfoService.insertCar(carInfoVO);
    }

    //차량 모델!!!조회1!!!
    @GetMapping("carModel")
    public List<CarInfoVO> getCarModelList(){
        return carInfoService.getCarModelList();
    }
}
