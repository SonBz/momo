package com.company;

public class CommonUtil {

    public static String formatCurrency(Long money) {
        return String.format("%,.0f", Double.valueOf(money));
    }
}
