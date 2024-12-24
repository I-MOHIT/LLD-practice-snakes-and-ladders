package models;

import java.util.Random;

public class Dice {
    private int minValue;
    private int maxValue;

    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(this.minValue, this.maxValue + 1);
    }
}
