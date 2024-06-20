package com.green.DataPractice.controller;

import com.green.DataPractice.vo.DeliveryVO;
import com.green.DataPractice.vo.MemberVO;
import com.green.DataPractice.vo.OrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderCntroller {


    //주문정보페이지로 이동
    @GetMapping("/order")
    public String order(){
        return "order";
    }

    //배달정보페이지로 이동
    @PostMapping("/delivery")
    public String delivery(OrderVO orderVO){
        System.out.println(orderVO);
        return "delivery";
    }

    //주문정보 확인 페이지로 이동
    @PostMapping("/info")
    public String info(OrderVO orderVO, DeliveryVO deliveryVO){
        System.out.println(orderVO);
        System.out.println(deliveryVO);
        return "order_info";
    }

}
