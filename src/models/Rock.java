package models;

import strategies.IMovingStrategy;

public class Rock extends BoardEntity{
    public Rock(int head, int tail, IMovingStrategy movingStrategy, String type) {
        super(head, tail, movingStrategy, type);
    }
}
