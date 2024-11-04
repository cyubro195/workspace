package com.green.Car_system.controller;

import com.green.Car_system.service.SalesInfoService;
import com.green.Car_system.vo.Sales_InfoVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_sales")
public class Sales_InfoController {
    @Resource(name = "salesInfoService")
    private SalesInfoService salesInfoService;

    //구매자 목록조회
    @GetMapping("getBuyList")
    public List<Sales_InfoVO> getBuyList(){
        return salesInfoService.getBuyList();
    }

    //구매자 등록
    @PostMapping("insertSales")
    public void insertSales(@RequestBody Sales_InfoVO sales_infoVO){
        salesInfoService.insertSales(sales_infoVO);
    }

}
