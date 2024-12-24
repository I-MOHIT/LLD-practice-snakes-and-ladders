package models;

public class Player {
    private int id;
    private String name;
    private int currPosition;
    private Boolean hasWon;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.currPosition = 0;
        this.hasWon = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }

    public Boolean getHasWon() {
        return hasWon;
    }

    public void setHasWon(Boolean hasWon) {
        this.hasWon = hasWon;
    }
}
