package com.aleksandr;

import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {
        System.out.println("Создаем 4 разных сладости: через функицональный интерфейс и класс, через создание нового объекта интерфейса и переопределения метода, и через лямда-выражение.");
        //создаем конфету через функциональный интерфейс SweetFactory и класс CreateCandy
        SweetFactory makeCandy = new CreateCandy();
        System.out.println(makeCandy.createSweet("конфета Мишка", 50, 200, "шоколадная"));
        //создаем конфету через функциональный интерфейс SweetFactory и класс CreateChoco
        SweetFactory makeChoco = new CreateChoco();
        System.out.println(makeChoco.createSweet("шоколадка Аленка", 80, 150, "для детей от 6 лет"));
        //переопределяем метод интерфейса для создания объекта нутелла и затем создаем новый объект типа нутелла
        SweetFactory makeNutella = new SweetFactory() {
            @Override
            public Sweet createSweet(String name, double price, double weight, String uhique) {
                if (name.contains("нутелла")) {
                    Nutella nutella = new Nutella(name, price, weight, uhique);
                    return nutella;
                }
                System.out.println("Фабрика производит только нутеллу");
                return null;
            }
        };
        System.out.println(makeNutella.createSweet("нутелла", 250, 300, "шоколадно-ореховая паста"));

        //создаем новый объект киндер сюрприз с помощью лямбды
        SweetFactory makeKinder = (name, price, weight, uhique) -> {
            if (name.contains("киндер")) {
                KinderSuprise kinderSuprise = new KinderSuprise(name, price, weight, uhique);
                return kinderSuprise;
            }
            System.out.println("Фабрика производит только киндер сюрприз");
            return null;
        };
        System.out.println(makeKinder.createSweet("киндер сюрприз", 150, 80, "шоколадное яйцо"));

        //создаем коробку
        Box box = new Box;




    }
}
