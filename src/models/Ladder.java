package models;

import strategies.IMovingStrategy;

public class Ladder extends BoardEntity{
    public Ladder(int head, int tail, IMovingStrategy movingStrategy, String type) {
        super(head, tail, movingStrategy, type);
    }
}
