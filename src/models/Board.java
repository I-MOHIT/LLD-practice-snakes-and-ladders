package models;

import strategies.IMovingStrategy;
import strategies.MoveToStartMovingStrategy;
import strategies.MovingToTailMovingStrategy;
import strategies.NoMoveMovingStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board {
    private int size;
    private int numOfSnakes;
    private int numOfLadders;
    private int numOfRocks;
    private int numOfHoles;
    private Map<Integer, BoardEntity> boardEntityHashMap;

    public Board(int size, int numOfSnakes, int numOfLadders, int numOfRocks, int numOfHoles) {
        this.size = size;
        this.numOfSnakes = numOfSnakes;
        this.numOfLadders = numOfLadders;
        this.numOfRocks = numOfRocks;
        this.numOfHoles = numOfHoles;
        boardEntityHashMap = new HashMap<>();
        this.createBoard();
    }

    private void createBoard() {
        Random random  = new Random();
        IMovingStrategy movingStrategy1 = new MovingToTailMovingStrategy();
        IMovingStrategy movingStrategy2 = new NoMoveMovingStrategy();
        IMovingStrategy movingStrategy3 = new MoveToStartMovingStrategy();

        for (int i = 0; i < numOfSnakes; i++) {
            int start = random.nextInt(3, size);
            int end = random.nextInt(1, start);
            BoardEntity snake = new Snake(start, end, movingStrategy1, "Snake");
            boardEntityHashMap.put(start, snake);
        }

        for (int i = 0; i < numOfLadders; i++) {
            int start = random.nextInt(2, size);
            int end = random.nextInt(start + 1, size);
            BoardEntity ladder = new Ladder(start, end, movingStrategy1, "Ladder");
            boardEntityHashMap.put(start, ladder);
        }

        for (int i = 0; i < numOfRocks; i++) {
            int start = random.nextInt(2, size);
            BoardEntity rock = new Rock(start, start, movingStrategy2, "Rock");
            boardEntityHashMap.put(start, rock);
        }

        for (int i = 0; i < numOfHoles; i++) {
            int start = random.nextInt(2, size);
            BoardEntity hole = new Hole(start, 0, movingStrategy3, "Hole");
            boardEntityHashMap.put(start, hole);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumOfSnakes() {
        return numOfSnakes;
    }

    public void setNumOfSnakes(int numOfSnakes) {
        this.numOfSnakes = numOfSnakes;
    }

    public int getNumOfLadders() {
        return numOfLadders;
    }

    public void setNumOfLadders(int numOfLadders) {
        this.numOfLadders = numOfLadders;
    }

    public int getNumOfRocks() {
        return numOfRocks;
    }

    public void setNumOfRocks(int numOfRocks) {
        this.numOfRocks = numOfRocks;
    }

    public int getNumOfHoles() {
        return numOfHoles;
    }

    public void setNumOfHoles(int numOfHoles) {
        this.numOfHoles = numOfHoles;
    }

    public Map<Integer, BoardEntity> getBoardEntityHashMap() {
        return boardEntityHashMap;
    }

    public void setBoardEntityHashMap(Map<Integer, BoardEntity> boardEntityHashMap) {
        this.boardEntityHashMap = boardEntityHashMap;
    }
}
