package com.aleksandr;

import java.util.function.Predicate;

public class AddWeightMoreThan200 implements Predicate<Sweet> {

    @Override
    public boolean test(Sweet sweet) {
        if (sweet.getWeight() < 200) {return false;}
        else {return true;}
    }
}
