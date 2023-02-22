package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class Coupons {

   private List<String> couponType = new ArrayList<>();

    private double couponDiscount;

    public double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public List<String> getCouponType() {
        return couponType;
    }

    public void setCouponType(List<String> couponType) {
        this.couponType = couponType;
    }


    public void addCoupons(String coupon) {
        List<String> list = getCouponType();
        list.add(coupon);
        setCouponType(list);
    }
}
