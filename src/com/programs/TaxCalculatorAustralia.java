package com.programs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorAustralia {

    public static void main(String args[]){
        System.out.println("result = " + calculateTax(180001));
    }

    public static String calculateTax(float income){
        float tax = 0.0f;
        //FURTHER CUSTOMIZE to remove hardcoding and then use for loop List<TaxSlab> taxSlabs =  new ArrayList<>();


        if(income <= 18200){
            tax =  0.00f;
        }
        if(income > 18200 ){ //&& income <= 37000
            tax = calculateSlabTax(18200,37000,0.19f,income,tax);  //19 cents in dollars is 90/100=0.19
        }
        if(income > 37000){  // && income <= 87000
            tax = calculateSlabTax(37000,87000,0.325f,income,tax);
        }
        if(income > 87000 ){ //&& income <=189000
            tax = calculateSlabTax(87000,180000,0.37f,income,tax);
        }
        if(income > 180000){
            income = income - 180000;
            tax +=  (income ) * 0.45f;
        }

        return new BigDecimal(tax).setScale(2, RoundingMode.HALF_DOWN).toPlainString();

    }

    private static float calculateSlabTax(float slabLower, float slabUpper,float slabRate,float income,float tax){
        float slabAmt = slabUpper - slabLower;
        float slabIncome = income - slabLower;
        if(slabIncome < slabAmt) {
            tax += slabIncome * slabRate;
        }else{
            tax += slabAmt * slabRate;
        }
        return tax;
    }
}
