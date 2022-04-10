package ru.gb.level1.lesson7;

public class Bowl {

    private int foodAmount;

    public void putFood(int amount) {
        this.foodAmount += amount;
        System.out.printf("Food increased by %d pts, there is now %d%n", amount, foodAmount);
    }

    public void takeFood(int amount) {
        if (amount > foodAmount) {
            System.out.printf("No enough food in this bowl. Current amount: %d, wanted: %d%n", foodAmount, amount);
            return;
        }
        this.foodAmount -= amount;
        System.out.printf("Food decreased by %d pts, there is now %d%n", amount, foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
