package com.tictactoea;

import java.util.Scanner;

public class Human extends Player {

    public Scanner enter = new Scanner(System.in);

    public Human(int player) {
        super(player);
        System.out.println(" Human ready to play!");
    }

    @Override
    public void playing(BoardGame gameBoard) {
        placing(gameBoard);
        gameBoard.setPosition(playerMove, player);
    }

    @Override
    public void placing(BoardGame gameBoard) {
        do {
            do {
                System.out.println("Row: ");
                playerMove[0] = enter.nextInt();

                if(playerMove[0] > 3 || playerMove[0] < 1)
                    System.out.println("Invalid row.( Valid rows [1,2,3])");

            } while(playerMove[0] > 3 || playerMove[0] < 1);

            do {

                System.out.println("Column: ");
                playerMove[1] = enter.nextInt();

                if(playerMove[1] > 3 || playerMove[1] < 1)
                    System.out.println("Invalid column.( Valid columns [1,2,3])");

            } while(playerMove[1] > 3 || playerMove[1] < 1);

            playerMove[0]--;
            playerMove[1]--;

            if(!checkingCell(playerMove, gameBoard))
                System.out.println("Used cell. Select new one.");

        } while(!checkingCell(playerMove, gameBoard));

    }

}
