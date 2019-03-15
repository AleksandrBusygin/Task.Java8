package com.aleksandr;

public class RublesToEuro implements CostCalculator {
    @Override
    public double PriceConverter(Box box) {
        for (int i=0; i < box.sweets.size(); i++) {
            return box.sweets.get(i).getPrice()/73.5;
        }
        return 0;
    }
}
