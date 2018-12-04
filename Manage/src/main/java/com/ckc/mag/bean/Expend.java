package com.ckc.mag.bean;

public class Expend {
    private Integer expid;

    private String item;

    private String price;

    private String num;

    private String total;

    public Expend(){

    }

    public Expend(Integer expid, String item, String price, String num, String total) {
        this.expid = expid;
        this.item = item;
        this.price = price;
        this.num = num;
        this.total = total;
    }

    public Integer getExpid() {
        return expid;
    }

    public void setExpid(Integer expid) {
        this.expid = expid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }
}