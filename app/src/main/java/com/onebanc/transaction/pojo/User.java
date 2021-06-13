package com.onebanc.transaction.pojo;

public class User {
    private int vPayId;
    private String vPay;

    public int getvPayId() {
        return vPayId;
    }

    public void setvPayId(int vPayId) {
        this.vPayId = vPayId;
    }

    public String getvPay() {
        return vPay;
    }

    public void setvPay(String vPay) {
        this.vPay = vPay;
    }

    @Override
    public String toString() {
        return "User{" +
                "vPayId=" + vPayId +
                ", vPay='" + vPay + '\'' +
                '}';
    }
}
