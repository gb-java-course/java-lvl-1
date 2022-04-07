package ru.gb.level1.lesson6;

public abstract class Animal {

    private static int animalCount = 0;

    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    protected abstract long getRunMaxDistance();
    protected abstract long getSwimMaxDistance();

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(long distance) {
        long distanceRan = Math.min(distance, getRunMaxDistance());
        System.out.printf("%s пробежал %d м\n", name, distanceRan);
    }

    public void swim(long distance) {
        long distanceSwam = Math.min(distance, getSwimMaxDistance());
        System.out.printf("%s проплыл %d м\n", name, distanceSwam);
    }
}
