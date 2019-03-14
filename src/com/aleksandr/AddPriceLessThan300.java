package com.aleksandr;

import java.util.function.Predicate;

public class AddPriceLessThan300 implements Predicate<Sweet> {

    @Override
    public boolean test(Sweet a) {
        if (300 < a.getPrice()) {return false;}
        else {return true;}
    }
}
