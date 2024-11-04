package com.green.Car_system.service;

import com.green.Car_system.vo.CarInfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carInfoService")
public class CarInfoServiceImpl implements CarInfoService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    //자동차 목록조회
    @Override
    public List<CarInfoVO> carList() {
        return sqlSession.selectList("carInfoMapper.carList");
    }

    //자동차 등록
    @Override
    public void insertCar(CarInfoVO carInfoVO) {
        sqlSession.insert("carInfoMapper.insertCar", carInfoVO);
    }

    //차량모델조회
    @Override
    public List<CarInfoVO> getCarModelList() {
        return sqlSession.selectList("salesInfoMapper.getCarModelList");
    }
}
