package com.aleksandr;

public abstract class Sweet {
    private String name;
    private double price;
    private double weight;



    public Sweet(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0.0D) {
            System.out.println("Цена может иметь только положительное значение");
        }

        this.price = price;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        if (weight < 0.0D) {
            System.out.println("Вес может иметь только положительное значение");
        }

        this.weight = weight;
    }

    public String toString() {
        return "Тип сладкого подарка: " + this.name;
    }
}