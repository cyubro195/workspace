package com.green.DataPractice.vo;

import java.util.Arrays;

public class ScoreVO {

    private String name;
    private String grade;
    private String[] tel;
    private String gender;
    private int korscore;
    private int mathscore;
    private int engscore;


    //get

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String[] getTel() {
        return tel;
    }

    public String getGender() {
        return gender;
    }

    public int getKorscore() {
        return korscore;
    }

    public int getMathscore() {
        return mathscore;
    }

    public int getEngscore() {
        return engscore;
    }


    //set

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTel(String[] tel) {
        this.tel = tel;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setKorscore(int korscore) {
        this.korscore = korscore;
    }

    public void setMathscore(int mathscore) {
        this.mathscore = mathscore;
    }

    public void setEngscore(int engscore) {
        this.engscore = engscore;
    }


    //tostr


    @Override
    public String toString() {
        return "ScoreVO{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", tel=" + Arrays.toString(tel) +
                ", gender='" + gender + '\'' +
                ", korscore=" + korscore +
                ", mathscore=" + mathscore +
                ", engscore=" + engscore +
                '}';
    }
}
