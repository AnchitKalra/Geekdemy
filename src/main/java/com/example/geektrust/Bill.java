package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bill {


    public void calculateBill(Programme programme, Membership membership, Coupons coupons) {
        double amount = Constants.ZERO;

        int quantityOf = Constants.ZEROINT;
        Map<String, Integer> mapOfProgrammes = programme.getQuantityOfProgammes();
        int  i = Constants.ZEROINT;
        double discount = Constants.ZERO;
        Double min = Double.valueOf(Integer.MAX_VALUE);
        double minCost = Constants.ZERO;

        for(String s : programme.typeOfProgrammes) {
            int quantity = mapOfProgrammes.get(s) != null ? mapOfProgrammes.get(s) : Constants.ZEROINT;
            quantityOf += quantity;
            double cost =Constants.ZERO;


            if(quantity > Constants.ZEROINT) {

                if(membership.getApplied()) {
                    minCost = programme.costOfProgrammes.get(i);
                    cost = quantity  * programme.costOfProgrammes.get(i);
                    discount += (cost * membership.discountApplicable.get(i))/ Constants.HUNDRED;
                    cost = cost - ((cost * (membership.discountApplicable.get(i))) / Constants.HUNDRED);
                    minCost = minCost - (minCost * membership.discountApplicable.get(i)) / Constants.HUNDRED;

                    if(minCost < min) {
                        min = minCost;
                    }


                }
                else {
                    cost = quantity * programme.costOfProgrammes.get(i);
                    minCost = programme.costOfProgrammes.get(i);
                    if(minCost < min) {
                        min = minCost;
                    }


                }

                amount += cost;
            }
            i++;

        }
        if(quantityOf >= Constants.FOUR) {
            if (min < Double.valueOf(Integer.MAX_VALUE)) {
                coupons.setCouponDiscount(min);
            }
        }
        if(membership.getApplied()) {
            membership.setProDiscount(discount);
            amount += membership.PRO_FEE;
        }

        System.out.println(Constants.SUB_TOTAL + " " + String.format(Constants.FORMAT, amount));


        amount = getDiscount(quantityOf, amount, coupons);
        System.out.println(Constants.COUPON_DISCOUNT + " " + coupons.getCouponType().get(Constants.ZEROINT) + " " + String.format(Constants.FORMAT, coupons.getCouponDiscount()));
        System.out.println(Constants.TOTAL_PRO_DISCOUNT + " " + (String.format(Constants.FORMAT,membership.getProDiscount())));
        System.out.println(Constants.PRO_MEMBERSHIP_FEE + " " + (membership.getApplied() ? String.format(Constants.FORMAT,membership.PRO_FEE) : String.format(Constants.FORMAT, Constants.ZERO)));
        boolean flag = false;
        if(amount < Constants.ENROLLMENTFEE) {
            amount += EnrollmentFee.ENROLLMENT_FEE;
            flag = true;
        }

        System.out.println(Constants.ENROLLMENT_FEE + " " + (flag ? String.format(Constants.FORMAT,EnrollmentFee.ENROLLMENT_FEE) : String.format(Constants.FORMAT, Constants.ZERO)));


        System.out.println(Constants.TOTAL + " " + String.format(Constants.FORMAT,amount));


    }

    public double getDiscount(int quantity, double amount, Coupons coupons) {
        List<String> couponList = coupons.getCouponType();
        if(quantity >= Constants.FOUR) {
            couponList = new ArrayList<>();
            couponList.add(Constants.B4G1);
            coupons.setCouponType(couponList);
            amount -= coupons.getCouponDiscount();
            return amount;
        }
        else {

            if(couponList.contains(Constants.DEAL_G20)) {
                if(amount >= Constants.COUPON_FEE) {
                    double cost = amount * Constants.DEAL2;
                    amount -= cost;
                    couponList = new ArrayList<>();
                    couponList.add(Constants.DEAL_G20);
                    coupons.setCouponType(couponList);
                    coupons.setCouponDiscount(cost);
                    return amount;
                }
                else if(couponList.contains(Constants.DEAL_G5)) {
                    if (quantity >= Constants.TWO) {
                        double cost = amount * Constants.DEAL3;
                        amount -= cost;
                        couponList = new ArrayList<>();
                        couponList.add(Constants.DEAL_G5);
                        coupons.setCouponType(couponList);
                        coupons.setCouponDiscount(cost);
                        return amount;
                    }
                }
                else {
                    couponList = new ArrayList<>();
                    couponList.add(Constants.NONE);
                    coupons.setCouponType(couponList);
                    return amount;
                }



            } else if (couponList.contains(Constants.DEAL_G5)) {
                if(quantity >= Constants.TWO) {
                    double cost = Constants.DEAL3 * amount;
                    amount -= cost;
                    couponList = new ArrayList<>();
                    couponList.add(Constants.DEAL_G5);
                    coupons.setCouponType(couponList);
                    coupons.setCouponDiscount(cost);
                    return amount;
                }
                else {
                    couponList = new ArrayList<>();
                    couponList.add(Constants.NONE);
                    coupons.setCouponType(couponList);
                    return amount;
                }

            }
            else {
                couponList = new ArrayList<>();
                couponList.add(Constants.NONE);
                coupons.setCouponType(couponList);
                return amount;
            }

        }
        return amount;
    }
}
