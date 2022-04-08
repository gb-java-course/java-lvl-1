package ru.gb.level1.lesson4;

import java.util.Random;
import java.util.Scanner;

public class GameApp {

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static char dotHuman;
    private static char dotAi;
    private static int scoreHuman;
    private static int scoreAi;

    private static int roundCounter;
    private static int winLength;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        startNewGame();
    }

    private static void startNewGame() {
        while (true) {
            System.out.print("Select size of game field: ");
            int fieldSize = scanner.nextInt();
            initField(fieldSize, fieldSize);

            System.out.print("Select length of win sequence: ");
            winLength = scanner.nextInt();

            chooseDot();
            playRound();

            System.out.printf("SCORE:    HUMAN     AI\n" +
                    "            %d       %d\n", scoreHuman, scoreAi);

            System.out.print("Want to play again ? (Y or N) >>> ");

            if (!scanner.next().equalsIgnoreCase("y")) {
                System.out.println("BYE");
                break;
            }
        }
    }

    private static void initField(int sizeX, int sizeY) {
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    private static void chooseDot() {
        System.out.print("Type 'X' to play with X and for 0 type anything >>> ");

        if (scanner.next().equalsIgnoreCase("x")) {
            dotHuman = DOT_X;
            dotAi = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAi = DOT_X;
        }
    }

    private static void playRound() {
        System.out.printf("Round %d start\n", ++roundCounter);
        printField();

        char currentDot = DOT_EMPTY;
        while (true) {
            currentDot = flipDot(currentDot);
            if (playTurnAndCheck(currentDot)) {
                break;
            }
            currentDot = flipDot(currentDot);
            if (playTurnAndCheck(currentDot)) {
                break;
            }
        }
    }

    private static void printField() {
        System.out.print("+");

        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }

        System.out.println();
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeY; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static char flipDot(char currentDot) {
        return currentDot == DOT_X ? DOT_O : DOT_X;
    }

    private static boolean playTurnAndCheck(int currentDot) {
        if (currentDot == dotHuman) {
            return playHumanTurnAndCheck();
        } else {
            return playAiTurnAndCheck();
        }
    }

    private static boolean playHumanTurnAndCheck() {
        humanTurn();
        printField();
        return gameCheck(dotHuman);
    }

    private static boolean playAiTurnAndCheck() {
        aiTurn();
        printField();
        return gameCheck(dotAi);
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Please enter coordinates x & y >>>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellNotValid(x, y));

        field[x][y] = dotHuman;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            int[] point = getNextAiPoint();
            x = point[0];
            y = point[1];
        } while (isCellNotValid(x, y));

        field[x][y] = dotAi;
    }

    private static boolean gameCheck(char dot) {
        if (checkWin(dot) && dot == dotHuman) {
            System.out.println("Human win!");
            scoreHuman++;
            return true;
        } else if (checkWin(dot) && dot == dotAi) {
            System.out.println("AI win!");
            scoreAi++;
            return true;
        }
        return checkDraw();
    }

    private static boolean checkWin(char dot) {
        for (int i = 0; i < field.length; i++) {
            if (checkHorizontalWin(dot, i)) {
                return true;
            }
            if (checkVerticalWin(dot, i)) {
                return true;
            }
        }
        return checkDiagonalWin(dot);
    }

    private static boolean checkHorizontalWin(char dot, int row) {
        int sequenceCount = 0;
        for (int j = 0; j < field[row].length; j++) {
            sequenceCount = field[row][j] == dot ? sequenceCount + 1 : 0;
            if (sequenceCount == winLength) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkVerticalWin(char dot, int row) {
        int sequenceCount = 0;
        for (int j = 0; j < field[row].length; j++) {
            sequenceCount = field[j][row] == dot ? sequenceCount + 1 : 0;
            if (sequenceCount == winLength) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonalWin(char dot) {
        int diagSequenceCount = 0;
        for (int i = 0; i < field.length; i++) {
            diagSequenceCount = field[i][i] == dot || field[i][field.length - i - 1] == dot
                    ? diagSequenceCount + 1
                    : 0;
            if (diagSequenceCount == winLength) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        System.out.println("DRAW!");
        return true;
    }

    private static boolean isCellNotValid(int x, int y) {
        return x < 0 || y < 0 || x >= fieldSizeX || y >= fieldSizeY || field[x][y] != DOT_EMPTY;
    }

    private static int[] getNextAiPoint() {
        // найти первую попавшуюся точку ИИ
        int[] firstPoint = getFirstAiPoint();
        if (firstPoint == null) {
            return getRandomPoint();
        }
        // найти соседнюю ИИ точку
        int[] nearestAiPoint = getNearestAiPoint(firstPoint);
        if (nearestAiPoint != null) {
            return getNextAiPoint(firstPoint, nearestAiPoint);
        }

        // найти соседнюю свободную ячейку
        int[] nearestFreePoint = getNearestFreePoint(firstPoint);
        if (nearestFreePoint != null) {
            return nearestFreePoint;
        }

        return getRandomPoint();
    }

    private static int[] getFirstAiPoint() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == dotAi) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    private static int[] getNearestAiPoint(int[] point) {
        int x = point[0];
        int y = point[1];
        int minI = Math.max(x - 1, 0);
        int maxI = Math.min(x + 1, fieldSizeX - 1);
        int minJ = Math.max(y - 1, 0);
        int maxJ = Math.min(y + 1, fieldSizeY - 1);
        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                if (i == x || j == y) {
                    continue;
                }
                if (field[i][j] == dotAi) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    private static int[] getNextAiPoint(int[] firstPoint, int[] nearestPoint) {
        // проверить свободна ли следующая ячейка в том направлении
        int x1 = firstPoint[0];
        int y1 = firstPoint[1];
        int x2 = nearestPoint[0];
        int y2 = nearestPoint[1];
        if (x1 - x2 != 0 && y2 + 1 < fieldSizeY && y1 - 1 >= 0) {
            if (field[x1][y2 + 1] == DOT_EMPTY) {
                return new int[] {x1, y2 + 1};
            }
            if (field[x1][y1 - 1] == DOT_EMPTY) {
                return new int[] {x1, y1 - 1};
            }
        }
        // если нет, то проверить в другом
        if (y1 - y2 != 0 && x2 + 1 < fieldSizeX && x1 - 1 >= 0) {
            if (field[x2 + 1][y1] == DOT_EMPTY) {
                return new int[] {x2 + 1, y1};
            }
            if (field[x1 - 1][y1] == DOT_EMPTY) {
                return new int[] {x1 - 1, y1};
            }
        }
        // если нет, то выбрать случайно любую свободную ячейку
        return getRandomPoint();
    }

    private static int[] getNearestFreePoint(int[] point) {
        int x = point[0];
        int y = point[1];
        int minI = Math.max(x - 1, 0);
        int maxI = Math.min(x + 1, fieldSizeX - 1);
        int minJ = Math.max(y - 1, 0);
        int maxJ = Math.min(y + 1, fieldSizeY - 1);
        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    private static int[] getRandomPoint() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (isCellNotValid(x, y));

        return new int[] {x, y};
    }
}
