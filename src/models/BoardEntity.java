package models;

import strategies.IMovingStrategy;

public abstract class BoardEntity {
    int head;
    int tail;
    IMovingStrategy movingStrategy;
    String type;

    public BoardEntity(int head, int tail, IMovingStrategy movingStrategy, String type) {
        this.head = head;
        this.tail = tail;
        this.movingStrategy = movingStrategy;
        this.type = type;
    }
}
