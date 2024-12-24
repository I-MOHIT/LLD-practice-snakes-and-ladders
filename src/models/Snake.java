package models;

import strategies.IMovingStrategy;

public class Snake extends BoardEntity{
    public Snake(int head, int tail, IMovingStrategy movingStrategy, String type) {
        super(head, tail, movingStrategy, type);
    }
}
