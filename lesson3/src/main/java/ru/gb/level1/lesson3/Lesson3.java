package ru.gb.level1.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Lesson3 {

    public static void main(String[] args) {
        int[] zeroOneArray = generateRandomZeroOneArray(10);
        System.out.println(Arrays.toString(zeroOneArray)); // [0, 0, 1, 1, 1, 1, 0, 1, 1, 1]
        replaceZeroOnes(zeroOneArray);
        System.out.println(Arrays.toString(zeroOneArray)); // [1, 1, 0, 0, 0, 0, 1, 0, 0, 0]

        int[] arrayToFill = new int[100];
        fillArrayFromOneToLength(arrayToFill);
        System.out.println(Arrays.toString(arrayToFill)); // [1, 2, 3, 4, 5, 6, 7 ... 97, 98, 99, 100]

        int[] predefinedArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyElementsLessSixByTwo(predefinedArray);
        System.out.println(Arrays.toString(predefinedArray)); // [2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]

        int n = 5;
        int[][] array2d = new int[n][n];
        fill2dArrayDiagonals(array2d);
        print2dArray(array2d);
//        1 0 0 0 1
//        0 1 0 1 0
//        0 0 1 0 0
//        0 1 0 1 0
//        1 0 0 0 1

        int[] filledArray = generateArrayWithValue(10, 5);
        System.out.println(Arrays.toString(filledArray)); // [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

        int[] minMaxArray = {-100, 20, -30, 3540, 0, 9, 198, -280, 1};
        printMinMaxOfArray(minMaxArray); // min: -280, max: 3540

        int[] leftRightArray1 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkLeftRightSumEqual(leftRightArray1)); // true
        int[] leftRightArray2 = {1, 1, 1, 2, 1};
        System.out.println(checkLeftRightSumEqual(leftRightArray2)); // true
        int[] leftRightArray3 = {2, 3, 2, 1, 2, 2, 10, 1};
        System.out.println(checkLeftRightSumEqual(leftRightArray3)); // false
        int[] leftRightArray4 = {2, 1, 1, 2, 1};
        System.out.println(checkLeftRightSumEqual(leftRightArray4)); // false
        int[] leftRightArray5 = {5, 1, 1, 2, 1};
        System.out.println(checkLeftRightSumEqual(leftRightArray5)); // true
        int[] leftRightArray6 = {1, 2, 1, 1, 5};
        System.out.println(checkLeftRightSumEqual(leftRightArray6)); // true

        int[] arrayToShiftRight = {1, 0, 3, 2, 5};
        System.out.println(Arrays.toString(arrayToShiftRight)); // [1, 0, 3, 2, 5]
        shiftArray(arrayToShiftRight, 3);
        System.out.println(Arrays.toString(arrayToShiftRight)); // [3, 2, 5, 1, 0]

        int[] arrayToShiftLeft = {1, 0, 3, 2, 5};
        System.out.println(Arrays.toString(arrayToShiftLeft)); // [1, 0, 3, 2, 5]
        shiftArray(arrayToShiftLeft, -3);
        System.out.println(Arrays.toString(arrayToShiftLeft)); // [2, 5, 1, 0, 3]
    }

    // task 1
    private static void replaceZeroOnes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] + 1) % 2;
        }
    }

    private static int[] generateRandomZeroOneArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(2);
        }
        return array;
    }

    // task 2
    private static void fillArrayFromOneToLength(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    // task 3
    private static void multiplyElementsLessSixByTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    // task 4
    private static void fill2dArrayDiagonals(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i == j || (array.length - 1 - i) == j ? 1 : 0;
            }
        }
    }

    private static void print2dArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // task 5
    private static int[] generateArrayWithValue(int length, int initialValue) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    // task 6
    private static void printMinMaxOfArray(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.printf("min: %d, max: %d\n", min, max);
    }

    // task 7
    private static boolean checkLeftRightSumEqual(int[] array) {
        int leftSum;
        int rightSum;
        for (int line = 1; line < array.length; line++) {
            leftSum = calcSumForArrayElements(array, 0, line);
            rightSum = calcSumForArrayElements(array, line, array.length);
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    private static int calcSumForArrayElements(int[] array, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }

    // task 8
    private static void shiftArray(int[] array, int n) {
        if (n == 0) {
            return;
        }

        int i = 0;
        int toWrite = array[0];
        int saved;
        int index;
        for (int shift = 0; shift < array.length; shift++) {
            index = n > 0
                    ? (i + n) % array.length
                    : (i + n + array.length) % array.length;
            saved = array[index];
            array[index] = toWrite;
            toWrite = saved;
            i = index;
        }
    }
}
