package com.green.DataPractice.vo;

public class DeliveryVO {

    private String buyer;
    private String tel;
    private String addr;

    //get


    public String getBuyer() {
        return buyer;
    }

    public String getTel() {
        return tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "DeliveryVO{" +
                "buyer='" + buyer + '\'' +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}

