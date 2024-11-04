package com.green.Car_system.service;

import com.green.Car_system.vo.Sales_InfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salesInfoService")
public class SalesInfoServiceImpl implements SalesInfoService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    //구매자 목록조회
    @Override
    public List<Sales_InfoVO> getBuyList() {
        return sqlSession.selectList("salesInfoMapper.getBuyList");
    }

    //구매자 등록
    @Override
    public void insertSales(Sales_InfoVO sales_infoVO) {
        sqlSession.insert("salesInfoMapper.insertSales", sales_infoVO);
    }
}
