package com.company;

public class Product {

    private String name;
    private Long price;
    private Integer total;

    public Product() {
    }

    public Product(String name, Long price, Integer total) {
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
