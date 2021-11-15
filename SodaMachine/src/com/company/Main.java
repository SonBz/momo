package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Service sodaMachine = new Service();
        Map<Integer, Product> productMap = sodaMachine.createProduct();
        List<Product> buyingList = new ArrayList<>();
        Long moneyTotal = sodaMachine.recharge();
        do {
            System.out.println("*Số tiền bạn có: " + CommonUtil.formatCurrency(moneyTotal) + Constant.VND);
            sodaMachine.viewProduct();
            Product product = sodaMachine.productSelect(productMap);
            System.out.println("Bạn chọn: " + product.getName() +
                    " - Số tiền cần thanh toán: " + CommonUtil.formatCurrency(product.getPrice()) + Constant.VND);
            if (!sodaMachine.validateMoney(product.getPrice(), moneyTotal)) {
                moneyTotal = moneyTotal + sodaMachine.recharge();
                System.out.println("*Số tiền bạn có: " + CommonUtil.formatCurrency(moneyTotal) + Constant.VND);
            }
            System.out.println("Bạn đồng ý mua sản phẩm: " + product.getName() +
                    " - với giá: " + CommonUtil.formatCurrency(product.getPrice()) + Constant.VND);
            System.out.println("1, Đồng ý.");
            System.out.println("2, Không đồng ý, hoàn tiền.");
            System.out.println("3, Đổi sản phẩm khác.");
            System.out.print("Nhập lựa chọn: ");
            Scanner currencySel = new Scanner(System.in);
            int resSel = currencySel.nextInt();
            switch (resSel) {
                case 1:
                    moneyTotal = moneyTotal - product.getPrice();
                    buyingList.add(product);
                    System.out.println("Xin cảm ơn, mua thành công.");
                    break;
                case 2:
                    System.out.println("*Số tiền hoàn bạn: " + CommonUtil.formatCurrency(moneyTotal) + Constant.VND);
                    moneyTotal = 0L;
                    break;
                case 3:
                    break;
            }
        } while (moneyTotal > 0L);
        System.out.println("*****Sản phẩm đã mua*****");
        buyingList.forEach(p -> System.out.println("Sản phẩm: " + p.getName() +
                "- Giá: " + CommonUtil.formatCurrency(p.getPrice()) + Constant.VND));
    }
}
