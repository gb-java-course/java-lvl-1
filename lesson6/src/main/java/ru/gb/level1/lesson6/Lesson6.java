package ru.gb.level1.lesson6;

public class Lesson6 {

    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Бобик"),
                new Dog("Шарик"),
                new Dog("Бим"),
                new Cat("Пушок"),
                new Cat("Барсик")
        };

        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(50);
        }

        System.out.println("===============================");

        System.out.printf(
                "animals: %d\ndogs: %d\ncats: %d\n",
                Animal.getAnimalCount(), Dog.getDogCount(), Cat.getCatCount()
        );

        // Бобик пробежал 300 м
        // Бобик проплыл 10 м
        // Шарик пробежал 300 м
        // Шарик проплыл 10 м
        // Бим пробежал 300 м
        // Бим проплыл 10 м
        // Пушок пробежал 200 м
        // Пушок проплыл 0 м
        // Барсик пробежал 200 м
        // Барсик проплыл 0 м
        // ===============================
        // animals: 5
        // dogs: 3
        // cats: 2
    }
}
