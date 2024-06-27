package com.green.ListPractice.vo;

import lombok.Data;

@Data
public class StudentVO {
    private int year;
    private String name;
    private int korScore;
    private int engScore;
    private String intro; //자기소개
//총점은 들어가지 않음

}
