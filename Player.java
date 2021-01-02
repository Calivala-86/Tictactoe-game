package com.tictactoea;

public abstract class Player {

    private final int EMPTY = 0;

    protected int[] playerMove = new int[2];
    protected int player;


    public Player(int player) {
        this.player = player;
    }

    public abstract void playing(BoardGame gameBoard);

    public abstract void placing(BoardGame gameBoard);

    public boolean checkingCell(int[] selectedCell, BoardGame gameBoard) {
        return gameBoard.getPosition(selectedCell) == EMPTY;
    }

}
