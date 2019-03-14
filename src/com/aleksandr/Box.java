package com.aleksandr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Box {
    public List<Sweet> sweets = new ArrayList<>();

    Predicate<Sweet> addSweet;

    public Box(Predicate<Sweet> addSweet){
        this.addSweet = addSweet;
    }

    public void add(Sweet sweet) {
        if(addSweet.test(sweet)) {
            sweets.add(sweet);
        } else {
            System.out.println("Сладость не удовлетворяет политике коробки!");
        }
    }

    public void delete(int index) {
        sweets.remove(index);
    }

    public void printAll(){
        sweets.forEach(System.out::println);
    }

    public void printFiltered(Predicate<Sweet> howFilter){
        sweets.stream().filter(howFilter).forEach(System.out::println);
    }

    public void totalCost(Predicate<Sweet> howFilter){
        sweets.stream().filter(howFilter).forEach(System.out::println);
    }

}
