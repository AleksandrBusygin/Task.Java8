package com.aleksandr;

@FunctionalInterface
public interface CostCalculator {
    abstract double PriceConverter(Box box);
}
