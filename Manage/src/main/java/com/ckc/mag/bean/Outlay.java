package com.ckc.mag.bean;

public class Outlay {
    private String num;

    private String outlay;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getOutlay() {
        return outlay;
    }

    public void setOutlay(String outlay) {
        this.outlay = outlay == null ? null : outlay.trim();
    }
}