package models;

import exceptions.NoPlayerFoundException;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    private Board board;
    private Deque<Player> players;
    private Dice dice;

    public Game(Board board, Dice dice) {
        this.board = board;
        players = new ArrayDeque<>();
        this.dice = dice;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void launchGame() {
        while(true) {
            Player currPlayer = players.pop();
            if (currPlayer == null) {
                throw new NoPlayerFoundException();
            }
            int currPosition = currPlayer.getCurrPosition();
            System.out.println("The current player is " + currPlayer.getName() + " and they are currently at " + currPosition);
            int valueRolled = this.dice.rollDice();
            System.out.println("The dice value rolled is " + valueRolled);

            int intermediatePosition = currPosition + valueRolled;
            if (intermediatePosition == board.getSize()) {
                System.out.println("Player " + currPlayer.getName() + " has won the game");
                currPlayer.setCurrPosition(intermediatePosition);
                currPlayer.setHasWon(true);
                return;
            } else if (intermediatePosition > board.getSize()) {
                System.out.println("The value rolled is beyond the end. Player " + currPlayer.getName() + " stays at " + currPosition);
            } else {
                // Here even if that the tail of one entity is the head of another entity is ignored primarily because if the player lands on a rock then they get stuck forever
                if (checkIfABoardEntityHasBeenEncountered(intermediatePosition)) {
                    BoardEntity boardEntity = this.board.getBoardEntityHashMap().get(intermediatePosition);
                    System.out.println("Player " + currPlayer.getName() + " has encountered a board entity of type " + boardEntity.type + " at " + intermediatePosition);
                    intermediatePosition = boardEntity.movingStrategy.move(boardEntity.tail);
                    System.out.println("Player " + currPlayer.getName() + " has moved to " + intermediatePosition + " because of the board entity " + boardEntity.type);
                }
                currPlayer.setCurrPosition(intermediatePosition);
                System.out.println("Player " + currPlayer.getName() + " roll is done and they've moved to " + currPlayer.getCurrPosition());
            }
            players.addLast(currPlayer);
        }
    }

    private Boolean checkIfABoardEntityHasBeenEncountered(int currPosition) {
        return this.board.getBoardEntityHashMap().containsKey(currPosition);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Deque<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Deque<Player> players) {
        this.players = players;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}