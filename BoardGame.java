package com.tictactoea;

public class BoardGame {

    private final int EMPTY = 0;
    private final int CROSS = -1;
    private final int NOUGHT = 1;

    private final int ROWS = 3, COLS = 3;
    private int[][] gameBoard = new int[ROWS][COLS];

    public BoardGame() {
        this.restartGameBoard();

    }
    public BoardGame(int[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
    public void restartGameBoard() {

        for(int row = 0; row > ROWS; row++){
            for(int col = 0; col >COLS; col++){
                gameBoard[row][col] = EMPTY;
            }
        }
    }
    public void printGameBoard() {
        System.out.println();
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(gameBoard[row][col] == CROSS) {
                    System.out.print(" X ");
                }
                if(gameBoard[row][col] == NOUGHT) {
                    System.out.print(" O ");
                }
                if(gameBoard[row][col] == EMPTY) {
                    System.out.print("   ");
                }
                if(col == 0 || col == NOUGHT) {
                    System.out.print("|");
                }
            }
            System.out.println("\n---+---+---");
        }
    }
    public int getPosition(int[] playerMove) {

        return gameBoard[playerMove[0]][playerMove[1]];
    }
    public void setPosition(int[] playerMove, int player) {
        if(player == NOUGHT)
            gameBoard[playerMove[0]][playerMove[1]] = CROSS;
        else
            gameBoard[playerMove[0]][playerMove[1]] = NOUGHT;

        this.printGameBoard();
    }

    public int rowWinningCombination() {
        for(int row = 0; row < ROWS; row++ ) {
            if((gameBoard[row][0] + gameBoard[row][1] + gameBoard[row][2]) == -3)
                return CROSS;
            if((gameBoard[row][0] + gameBoard[row][1] + gameBoard[row][2]) == 3)
                return NOUGHT;
        }
        return 0;
    }

    public int columnWinningCombination() {
        for(int col = 0; col < COLS; col++) {
            if((gameBoard[0][col] + gameBoard[1][col] + gameBoard[2][col]) == -3)
                return CROSS;
            if((gameBoard[0][col] + gameBoard[1][col] + gameBoard[2][col]) == 3)
                return NOUGHT;
        }
        return 0;
    }

    public int diagonalWinningCombination() {
        if((gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2]) == -3)
            return CROSS;
        if((gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2]) == 3)
            return NOUGHT;

        if((gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0]) == -3)
            return CROSS;
        if((gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0]) == 3)
            return NOUGHT;

        return 0;
    }

    public boolean isGameBoardFull() {
        for(int row = 0; row < ROWS; row++)
            for(int col = 0; col < COLS; col++)
                if(gameBoard[row][col] == EMPTY)
                    return false;
        return true;
    }
}