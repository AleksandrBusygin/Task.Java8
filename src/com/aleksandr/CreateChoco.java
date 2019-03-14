package com.aleksandr;

public class CreateChoco implements SweetFactory {
    @Override
    public Sweet createSweet(String name, double price, double weight, String uhique) {
        if (name.contains("шоколадка")) {
            Choco choco = new Choco(name, price, weight, uhique);
            return choco;
        }
        System.out.println("Фабрика производит только шоколадки");
        return null;
    }
}