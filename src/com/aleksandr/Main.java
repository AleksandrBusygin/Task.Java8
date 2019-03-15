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

        //создаем коробку, в которую можно положить только сладости дешевле 300 рублей через класс с предикатом
        System.out.println("Cоздаем коробку, в которую можно положить только сладости дешевле 300 рублей");
        Box box = new Box(new AddPriceLessThan300());
        box.add(new Choco("шоколадка элитная", 350,100, "большая"));
        box.add(new Choco("шоколадка ритерспорт",200,120,"с орехами"));
        box.printAll();

        //создаем коробку, в которую можно положить только сладости c весом более 200 грамм через класс с предикатом
        System.out.println("Создаем коробку, в которую можно положить только сладости c весом более 200 грамм");
        Box box1 = new Box(new AddWeightMoreThan200());
        box1.add(new Candy("конфета для настоящих мужиков", 400,100, "18+"));
        box1.add(new Candy("конфета детская",200,250,"жевательная"));
        box1.printAll();

        //создаем коробку, в которую можно положить только сладости c ценой 100 рублей через переобределение метода тест в предикате
        System.out.println("Создаем коробку, в которую можно положить только сладости c ценой 100 рублей");
        Box box100 = new Box(new Predicate<Sweet>() {
            @Override
            public boolean test(Sweet sweet) {
                if (sweet.getPrice() != 100) {
                    return false;
                } else {
                    return true;
                }
            }
        });
        box100.add(new KinderSuprise("киндер", 50,100,"по акции"));
        box100.add(new KinderSuprise("киндер", 100,100,"без акции"));
        box100.printAll();

        //создаем коробку, в которую можно положить только сладости c ценой 200 рублей через лямбду
        System.out.println("Создаем коробку, в которую можно положить только сладости c ценой 200 рублей через лямбда выражение");
        Predicate<Sweet> AddPrice200 = sweet -> sweet.getPrice() == 200;
        Box box200 = new Box(AddPrice200);
        box200.add(new Nutella("нутеллла", 250,100,"с орехами"));
        box200.add(new Nutella("нутелла", 200,100,"без орехов"));
        box200.printAll();


        //через класс RublesToEuro и интерфейс CostCalculator узнаем цену сладостей в коробке в евро
        System.out.println("Через класс RublesToEuro и интерфейс CostCalculator узнаем цену сладостей в коробке в евро");
        CostCalculator re = new RublesToEuro();
        System.out.println("Цена единственной сладости из предыдущей коробки в евро будет равна: " + re.PriceConverter(box200));

        //через интерфейс CostCalculator и переопределение метода узнаем цену сладостей в коробке в долларах
        System.out.println("Через интерфейс CostCalculator и переопределение метода узнаем цену сладостей в коробке в долларах");
        CostCalculator rd = new CostCalculator() {
            @Override
            public double PriceConverter(Box box) {
                for (int i=0; i < box.sweets.size(); i++) {
                    return box.sweets.get(i).getPrice()/65;
                }
                return 0;
            }
        };
        System.out.println("Цена единственной сладости из предыдущей коробки в долларах будет равна: " + rd.PriceConverter(box200));

        //через интерфейс CostCalculator и лямбда выражение узнаем цену сладостей в коробке в шведских кронах
        System.out.println("Через интерфейс CostCalculator и лямбда выражение узнаем цену сладостей в коробке в шведских кронах");
        CostCalculator rsw = box2 ->
        {
            for (int i=0; i < box2.sweets.size(); i++) {
            return box2.sweets.get(i).getPrice()/70;
        }
        return 0;
        };
        System.out.println("Цена единственной сладости из предыдущей коробки в шведских кронах будет равна: " + rsw.PriceConverter(box200));

        //создадим новую коробку и положим в нее сладости для работы со Stream API
        System.out.println("Cоздадим новую коробку(у которой предикат, требующий вес сладости более 200 грамм) и положим в нее сладости для работы со Stream API:");
        Box boxApi = new Box(new AddWeightMoreThan200());
        boxApi.add(new Candy("конфета для настоящих мужиков", 400,210, "18+"));
        boxApi.add(new Candy("конфета детская",200,250,"жевательная"));
        boxApi.add(new Nutella("нутеллла", 250,220,"с орехами"));
        boxApi.add(new Nutella("нутелла", 200,250,"без орехов"));
        boxApi.add(new KinderSuprise("киндер", 50,300,"по акции"));
        boxApi.add(new KinderSuprise("киндер", 100,400,"без акции"));
        boxApi.add(new Choco("шоколадка элитная", 350,500, "большая"));
        boxApi.add(new Choco("шоколадка ритерспорт",200,220,"с орехами"));
        boxApi.printAll();

        //воспользуемся методами из класса Box: printFiltered, totalCost
        System.out.println("Воспользуемся методами из класса Box: printFiltered, totalCost");
        System.out.println("Выведем сладости, из этой коробки, цена которых больше 200: ");
        boxApi.printFiltered(sweet -> sweet.getPrice() > 200);
        System.out.println("Выведем сладости, из этой коробки, вес которых меньше 300");
        boxApi.printFiltered(sweet -> sweet.getWeight() < 300);














    }
}
