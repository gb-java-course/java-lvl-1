package ru.gb.level1.lesson6;

public class Dog extends Animal {

    private static final long RUN_MAX_DISTANCE = 500L;
    private static final long SWIM_MAX_DISTANCE = 10L;

    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    protected long getRunMaxDistance() {
        return RUN_MAX_DISTANCE;
    }

    @Override
    protected long getSwimMaxDistance() {
        return SWIM_MAX_DISTANCE;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
