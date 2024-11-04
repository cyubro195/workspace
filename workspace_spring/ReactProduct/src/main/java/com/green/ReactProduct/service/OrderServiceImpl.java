package com.green.ReactProduct.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SqlSessionTemplate sqlSession;



}
