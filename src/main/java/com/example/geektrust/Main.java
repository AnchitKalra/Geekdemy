package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    Programme programme;


    Coupons coupons;

    Membership membership;

    Bill bill;

    Main() {
        programme = new Programme();
        coupons = new Coupons();
        membership = new Membership();
        bill = new Bill();
    }
    public static void main(String[] args) {

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned

            Main main = new Main();
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String s = sc.nextLine();
                String input[] = s.split(" ");




                if(input[0].equalsIgnoreCase(Constants.ADD_PROGRAMME)) {
                     main.programme.addProgramme(input[1], Integer.valueOf(input[2]));
                } else if (input[0].equalsIgnoreCase(Constants.COUPON)) {
                    main.coupons.addCoupons(input[1]);

                } else if (input[0].equalsIgnoreCase(Constants.PRO)) {
                    main.membership.addPro();

                } else if(input[0].equalsIgnoreCase(Constants.PRINT)) {
                    main.bill.calculateBill(main.programme, main.membership, main.coupons);
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
