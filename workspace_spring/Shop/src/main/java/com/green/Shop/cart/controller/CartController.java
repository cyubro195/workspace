package com.green.Shop.cart.controller;

import com.green.Shop.cart.service.CartSerVice;
import com.green.Shop.cart.vo.CartVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_cart")
public class CartController {
    @Resource(name = "cartService")
    private CartSerVice cartSerVice;

    //장바구니 상품등록
    @PostMapping("/insert")
    public void insertCart(@RequestBody CartVO cartVO){
        cartSerVice.insertCart(cartVO);
    }

    //장바구니 목록조회
    @GetMapping("/getCartList/{memId}")
    public List<CartVO> getCartList(@PathVariable("memId")String memId){
        return cartSerVice.getCartList(memId);
    }



}
