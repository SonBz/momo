package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Service {

    public Map<Integer, Product> createProduct() {
        Map<Integer, Product> productMap = new HashMap<>();
        productMap.put(Constant.COKE, new Product("Coke", 10000L, 2));
        productMap.put(Constant.PEPSI, new Product("Pepsi", 10000L, 10));
        productMap.put(Constant.SODA, new Product("Soda", 20000L, 10));
        return productMap;
    }

    public Product productSelect(Map<Integer, Product> productRes) {
        Product product = new Product();
        System.out.print("Bạn chọn sản phẩm : ");
        do {
            Scanner selectProduct = new Scanner(System.in);
            int key = selectProduct.nextInt();
            product = productRes.get(key);
            product.setTotal(product.getTotal() - 1);
            if (product.getTotal() < 0) {
                System.out.print("Sản phẩm đã hết, bạn chọn sản phẩm khác: ");
            }
            if (null == product) {
                System.out.print("Sản phẩm bạn chọn ko tồn tại chọn lại sản phẩm : ");
            }
        } while (null == product || product.getTotal() < 0);
        return product;
    }

    public void viewProduct() {
        System.out.println("Lựa chọn sản phẩm");
        this.createProduct().forEach((i, p) ->
                System.out.println(i + ", " + p.getName() + "-" + CommonUtil.formatCurrency(p.getPrice()) + Constant.VND)
        );
    }

    public Long recharge() {
        Long money = 0L;
        do {
            System.out.println("Bạn nạp số tiền :");
            System.out.println("1, 10,000");
            System.out.println("2, 20,000");
            System.out.println("3, 50,000");
            System.out.println("4, 100,000");
            System.out.println("5, 200,000");
            System.out.println("6, Thoát");
            System.out.print("Nhập 1, 2, 3, 4, 5 hoặc 6: ");
            Scanner currencySel = new Scanner(System.in);
            int keyCurrency = currencySel.nextInt();
            switch (keyCurrency) {
                case 1:
                    money = 10000L;
                    break;
                case 2:
                    money = 20000L;
                    break;
                case 3:
                    money = 50000L;
                    break;
                case 4:
                    money = 100000L;
                    break;
                case 5:
                    money = 200000L;
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (money == 0L);
        return money;
    }

    public Boolean validateMoney(Long price, Long moneyTotal) {
        if (price > moneyTotal) {
            System.out.println("Số tiền bạn không đủ để mua sản phẩm bạn cần nạp thêm tiền.");
            return false;
        }
        return true;
    }
}
