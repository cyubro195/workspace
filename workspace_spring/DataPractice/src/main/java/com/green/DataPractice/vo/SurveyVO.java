package com.green.DataPractice.vo;

import java.util.Arrays;

public class SurveyVO {

    private String intro;
    private String gender;
    private String[] hobby; //3개이니까 문자열로 넣어주기!
    private String path;

    public String getIntro() {
        return intro;
    }

    public String getGender() {
        return gender;
    }

    public String[] getHobby() {
        return hobby;
    }

    public String getPath() {
        return path;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "SurveyVO{" +
                "intro='" + intro + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", path='" + path + '\'' +
                '}';
    }
}
