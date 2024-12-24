import models.Board;
import models.Dice;
import models.Game;
import models.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the game of Snakes and Ladders");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the board required");
        int boardSize = scanner.nextInt();
        System.out.println("Enter the number of snakes on the board required");
        int snakes = scanner.nextInt();
        System.out.println("Enter the number of ladders on the board required");
        int ladders = scanner.nextInt();
        System.out.println("Enter the number of rocks on the board required");
        int rocks = scanner.nextInt();
        System.out.println("Enter the number of holes on the board required");
        int holes = scanner.nextInt();

        Board board = new Board(boardSize, snakes, ladders, rocks, holes);

        Dice dice  = new Dice(1, 6);

        Game game = new Game(board, dice);

        System.out.println("Enter the number of players playing the game");
        int players = scanner.nextInt();

        for (int i = 0; i < players; i++) {
            System.out.println("Enter Player " + (i + 1) + " name");
            String playerName = scanner.next();
            scanner.nextLine();
            Player player = new Player((i + 1), playerName);
            game.addPlayer(player);
        }
        game.launchGame();
    }
}