package models;

import strategies.IMovingStrategy;

public class Hole extends BoardEntity{
    public Hole(int head, int tail, IMovingStrategy movingStrategy, String type) {
        super(head, tail, movingStrategy, type);
    }
}
