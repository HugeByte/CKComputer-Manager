package com.ckc.mag.bean;

import javax.validation.constraints.Pattern;

public class Member {
    private Integer memid;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,6})",
            message = "姓名格式错误，请重新输入")
    private String name;

    @Pattern(regexp="^[\\u2E80-\\u9FFF]{2}\\d{4}$",
            message = "格式不正确，正确格式为【专业+班级】，如【软工1502】")
    private String major;

    private String qq;

    private String phone;

    private String pay;

    private String pic;

    public Member() {

    }

    public Member(Integer memid, String name, String major, String qq, String phone, String pay, String pic) {
        this.memid = memid;
        this.name = name;
        this.major = major;
        this.qq = qq;
        this.phone = phone;
        this.pay = pay;
        this.pic = pic;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay == null ? null : pay.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}