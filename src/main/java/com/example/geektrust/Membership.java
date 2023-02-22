package com.example.geektrust;

import java.util.ArrayList;


public class Membership {

    private static final String PRO = "PRO";

    public static final Double PRO_FEE = 200.00;

    private Double proDiscount = 0.00;

    public Double getProDiscount() {
        return proDiscount;
    }

    public void setProDiscount(Double proDiscount) {
        this.proDiscount = proDiscount;
    }

    public static final ArrayList<Integer> discountApplicable = new ArrayList<>();

    private Boolean isApplied = false;

    public Boolean getApplied() {
        return isApplied;
    }

    public void setApplied(Boolean applied) {
        isApplied = applied;
    }

    public Membership() {
        discountApplicable.add(2);
        discountApplicable.add(3);
        discountApplicable.add(1);
    }

    public void addPro() {
        setApplied(true);
    }

}
