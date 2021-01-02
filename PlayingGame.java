package com.tictactoea;

import java.util.Scanner;

public class PlayingGame {

    private final int EMPTY = 0;
    private final int CROSS = -1;
    private final int NOUGHT = 1;

    private BoardGame gameBoard;
    private Player player1;
    private Player player2;
    private int round;
    private int turn;
    public Scanner enter = new Scanner(System.in);

    public PlayingGame() {
        gameBoard = new BoardGame();
        startingPlaying();
        while (playing()) ;
    }

    public void startingPlaying() {
        System.out.println("Select player 1 ?");
        if (selectedPlayer() == CROSS)
            this.player1 = new Computor(1);
        else
            this.player1 = new Human(1);

        System.out.println("---------------------");
        System.out.println("Select player 2 ?");

        if (selectedPlayer() == NOUGHT)
            this.player2 = new Human(2);
        else
            this.player2 = new Computor(2);

    }

    public int selectedPlayer() {
        int option = 0;
        do {
            System.out.println("1. Player");
            System.out.println("2. Computor\n");
            System.out.println("Option: ");
            option = enter.nextInt();

            if (option != 1 && option != 2)
                System.out.println("Invalid option! Try again :(");
        } while (option != 1 && option != 2);

        return option;
    }

    public boolean playing() {
        if (hasWon() == EMPTY) {
            System.out.println("\nRound " + round);
            System.out.println("Your turn player " + turn());

            if (turn() == NOUGHT)
                player1.playing(gameBoard);
            else
                player2.playing(gameBoard);

            if (gameBoard.isGameBoardFull()) {
                System.out.println("Game Board full. Draw game!!!");
                return false;
            }

            turn++;
            round++;
            return true;
        } else {
            if (hasWon() == CROSS)
                System.out.println("Player won!!!");
            else
                System.out.println("Computor Won!!!");
            return false;
        }
    }

    public int turn() {

        return (turn % 2 == 1) ? 1 : 2;
    }

    public int hasWon() {
        if (gameBoard.columnWinningCombination() == NOUGHT)
            return NOUGHT;
        if (gameBoard.rowWinningCombination() == NOUGHT)
            return NOUGHT;
        if (gameBoard.diagonalWinningCombination() == NOUGHT)
            return NOUGHT;

        if (gameBoard.rowWinningCombination() == CROSS)
            return CROSS;
        if (gameBoard.columnWinningCombination() == CROSS)
            return CROSS;
        if (gameBoard.diagonalWinningCombination() == CROSS)
            return CROSS;

        return 0;
    }
}



