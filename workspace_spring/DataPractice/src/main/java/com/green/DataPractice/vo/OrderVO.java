package com.green.DataPractice.vo;

import java.util.Arrays;

public class OrderVO {
    private String type;
    private int cnt;
    private String[] option;
    private String request;


    //get

    public String getType() {
        return type;
    }

    public int getCnt() {
        return cnt;
    }

    public String[] getOption() {
        return option;
    }

    public String getRequest() {
        return request;
    }

    //set
    public void setType(String type) {
        this.type = type;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setOption(String[] option) {
        this.option = option;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "type='" + type + '\'' +
                ", cnt=" + cnt +
                ", option=" + Arrays.toString(option) +
                ", request='" + request + '\'' +
                '}';
    }
}
