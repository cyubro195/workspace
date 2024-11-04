package com.green.ReactProduct.service;

import com.green.ReactProduct.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    //상품조회
    @Override
    public List<ItemVO> getItemList() {
        List<ItemVO> itemList = sqlSession.selectList("itemMapper.getItemList");
        return itemList;
    }
}

