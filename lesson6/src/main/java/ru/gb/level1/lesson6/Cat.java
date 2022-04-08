package ru.gb.level1.lesson6;

public class Cat extends Animal {

    private static final long RUN_MAX_DISTANCE = 200L;
    private static final long SWIM_MAX_DISTANCE = 0L;

    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    protected long getRunMaxDistance() {
        return RUN_MAX_DISTANCE;
    }

    @Override
    protected long getSwimMaxDistance() {
        return SWIM_MAX_DISTANCE;
    }

    public static int getCatCount() {
        return catCount;
    }
}
