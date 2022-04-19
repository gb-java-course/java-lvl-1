package ru.gb.level1.lesson7;

public class Cat {

    private final String name;
    private final int appetite;

    private boolean fedUp;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fedUp = false;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() < appetite) {
            System.out.printf("Bowl has not enough food for %s, food amount: %d, cat appetite: %d%n",
                    name,  bowl.getFoodAmount(), appetite);
            return;
        }
        bowl.takeFood(appetite);
        fedUp = true;

        System.out.printf("Cat %s has eaten %d food%n", name, appetite);
    }

    public String getName() {
        return name;
    }

    public boolean isFedUp() {
        return fedUp;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", fedUp=" + fedUp +
                '}';
    }
}
