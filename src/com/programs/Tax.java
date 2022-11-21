package com.programs;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class Tax {

    public static void main(String[] args) {
        Tax tax = new Tax();
        System.out.println(tax.calculateTax(180001));
    }

    public String calculateTax(float income) {
        List<TaxBracket> taxBrackets = TaxHelper.listTax();
        float tax = 0.0f;
        for (TaxBracket taxBracket : taxBrackets) {
            if (income > taxBracket.getMax()) {
                tax = taxBracket.getTotal();
            } else {
                tax += (income - taxBracket.getMin() + 1) * taxBracket.getTaxRate();
                break;
            }
        }

        BigDecimal taxb = BigDecimal.valueOf(tax);
        return taxb.setScale(2, RoundingMode.HALF_DOWN).toPlainString();
    }

}


class TaxHelper {
    public static List<TaxBracket> listTax() {
        TaxBracket first = new TaxBracket(0, 1, 18200, 0);
        TaxBracket second = new TaxBracket(0.19f, 18201, 37000, (37000 - first.getMax()) * 0.19f);
        TaxBracket third = new TaxBracket(0.325f, 37001, 87000, (87000 - second.getMax()) * 0.325f + second.getTotal());
        TaxBracket fourth = new TaxBracket(0.37f, 87001, 180000, (180000 - third.getMax()) * 0.37f + third.getTotal());
        TaxBracket fifth = new TaxBracket(0.45f, 180001, Integer.MAX_VALUE, (180000 - fourth.getMax()) * 0.45f + fourth.getTotal());
        return Arrays.asList(first, second, third, fourth, fifth);
    }
}

class TaxBracket {
    float taxRate;
    int min;
    int max;
    float total;

    public TaxBracket(float taxRate, int min, int max, float total) {
        this.taxRate = taxRate;
        this.min = min;
        this.max = max;
        this.total = total;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public float getTotal() {
        return total;
    }
}

