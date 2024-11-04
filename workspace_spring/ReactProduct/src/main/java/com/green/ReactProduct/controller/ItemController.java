package com.green.ReactProduct.controller;

import com.green.ReactProduct.service.ItemService;
import com.green.ReactProduct.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Resource(name = "ItemService")
    private ItemService itemService;


    //상품리스트 조회
    @GetMapping("/itemList")
    public List<ItemVO> itemList() {
        return itemService.getItemList();
    }
}
