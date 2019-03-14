package com.aleksandr;

@FunctionalInterface
interface SweetFactory {
    abstract Sweet createSweet(String name, double price, double weight, String uhique);
}
