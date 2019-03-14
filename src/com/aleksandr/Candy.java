package com.aleksandr;

public class Candy extends Sweet {
    private String uhique;
    public Candy(String name, double price, double weight, String uhique) {
        super(name, price, weight);
        this.uhique = uhique;
    }

    public String getUhique(){
        return uhique;
    }

    public void setUhique(String uhique) {
        this.uhique = uhique;
    }

    @Override
    public String toString() {
        return "Тип сладости: " + getName() + ", цена: " + getPrice() + ", вес: " + getWeight() + ", дополнительно: " + uhique;
    }
}
