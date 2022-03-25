package ru.gb.level1.lesson2;

public class Lesson2 {

    public static void main(String[] args) {
        System.out.println(checkSum(5, 5)); // true
        System.out.println(checkSum(5, 3)); // false
        System.out.println(checkSum(5, 15)); // true
        System.out.println(checkSum(5, 20)); // false

        checkSignAndPrint(-10); // Отрицательное
        checkSignAndPrint(0); // Положительное
        checkSignAndPrint(10); // Положительное

        System.out.println(isNegative(-10)); // true
        System.out.println(isNegative(0)); // false
        System.out.println(isNegative(10)); // false

        print("Строка, которую надо вывести несколько раз", 5);

        System.out.println(isLeapYear(100)); // false
        System.out.println(isLeapYear(200)); // false
        System.out.println(isLeapYear(400)); // true
        System.out.println(isLeapYear(4)); // true
        System.out.println(isLeapYear(1998)); // false
        System.out.println(isLeapYear(2000)); // true
    }

    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkSignAndPrint(int num) {
        System.out.println(num >= 0 ? "Положительное" : "Отрицательное");
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static void print(String line, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(line);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }
}
