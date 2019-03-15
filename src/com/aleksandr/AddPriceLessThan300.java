package com.aleksandr;

import java.util.function.Predicate;

public class AddPriceLessThan300 implements Predicate<Sweet> {

    @Override
    public boolean test(Sweet a) {
        if (a.getPrice() > 300) {return false;}
        else {return true;}
    }
}
