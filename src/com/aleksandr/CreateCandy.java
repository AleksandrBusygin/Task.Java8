package com.aleksandr;

public class CreateCandy implements SweetFactory {
    @Override
    public Sweet createSweet(String name, double price, double weight, String uhique) {
        if (name.contains("конфета")) {
            Candy candy = new Candy(name, price, weight, uhique);
            return candy;
        }
        System.out.println("Фабрика производит только конфеты");
        return null;
    }
}
