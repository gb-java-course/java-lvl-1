package ru.gb.level1.lesson7;

public class Lesson7 {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Пушок", 10),
                new Cat("Барсик", 20),
                new Cat("Мурзик", 50),
                new Cat("Дымок", 30),
                new Cat("Мурка", 40)
        };

        Bowl bowl = new Bowl();
        bowl.putFood(100);
        //Food increased by 100 pts, there is now 100

        makeCatsEat(cats, bowl);
        //Food decreased by 10 pts, there is now 90
        //Cat Пушок has eaten 10 food
        //Food decreased by 20 pts, there is now 70
        //Cat Барсик has eaten 20 food
        //Food decreased by 50 pts, there is now 20
        //Cat Мурзик has eaten 50 food
        //Bowl has not enough food for Дымок, food amount: 20, cat appetite: 30
        //Bowl has not enough food for Мурка, food amount: 20, cat appetite: 40

        printCatsFeedInfo(cats);
        //Пушок is fed up
        //Барсик is fed up
        //Мурзик is fed up
        //Дымок is not fed up
        //Мурка is not fed up

        if (!isAllCatsFedUp(cats)) {
            bowl.putFood(100);
            //Food increased by 100 pts, there is now 120

            makeCatsEat(cats, bowl);
            //Food decreased by 30 pts, there is now 90
            //Cat Дымок has eaten 30 food
            //Food decreased by 40 pts, there is now 50
            //Cat Мурка has eaten 40 food

            printCatsFeedInfo(cats);
            //Пушок is fed up
            //Барсик is fed up
            //Мурзик is fed up
            //Дымок is fed up
            //Мурка is fed up
        }
    }

    private static void makeCatsEat(Cat[] cats, Bowl bowl) {
        for (var cat : cats) {
            if (cat.isFedUp()) {
                continue;
            }
            cat.eat(bowl);
        }
    }

    private static void printCatsFeedInfo(Cat[] cats) {
        for (var cat: cats) {
            System.out.printf("%s is %s%n", cat.getName(), cat.isFedUp() ? "fed up" : "not fed up");
        }
    }

    private static boolean isAllCatsFedUp(Cat[] cats) {
        for (var cat: cats) {
            if (!cat.isFedUp()) {
                return false;
            }
        }

        return true;
    }
}
