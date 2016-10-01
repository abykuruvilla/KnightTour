package com.aby.knight;

import java.util.Iterator;

public class KnightsMove implements Game {

    /** The 2D chess grid. */
    protected int[][] grid;
    /** The starting position of the knight. */
    protected Position start;
    /** The exit position on the chess board(goal position). */
    protected Position finish;
    /** Initial count of moves */
    public static int count = 1;
    /** Dead End */
    public static final int DEAD_END = 0;
    /** The Board object */
    private Board board;

    /**
     * Instantiates a new knight object.
     * 
     * @param rowSize
     *            the row size of grid
     * @param colSize
     *            the column size of grid
     * @param startPosition
     *            the start position
     * @param finalPosition
     *            the final position
     */
    public KnightsMove(int rowSize, int colSize, Position startPosition,
            Position finalPosition) {
        grid = new int[rowSize][colSize];
        this.start = startPosition;
        this.finish = finalPosition;
    }

    @Override
    public boolean isPositionOk(Position pos) {
        // check to see that the position is within the grid and not visited
        return pos.getRow() >= 0 && pos.getRow() < grid.length
                && pos.getColumn() >= 0 && pos.getColumn() < grid[0].length
                && grid[pos.getRow()][pos.getColumn()] == 0;
    }

    @Override
    public void markPositionAsPossible(Position pos) {
        if (this.isPositionOk(pos)) {
            grid[pos.getRow()][pos.getColumn()] = count;
            // display next move
            System.out.println("\n MOVE : " + count);
            board = new Board();
            board.setPosition(board, pos.getRow(), pos.getColumn());
            board.showBoard();

            count++;
        }
    }

    @Override
    public boolean isGoalPosition(Position pos) {
        // for the 3x3 grid there are a total of 9 positions that are possible,
        // of which the center value cannot be reached
        // exit if the final position is reached first
        if ((count == (grid.length * grid[0].length) + 1) || pos.equals(finish)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void markPositionAsDeadEnd(Position pos) {
        // mark as dead end and backtrack count
        grid[pos.getRow()][pos.getColumn()] = DEAD_END;
        count--;
    }

    @Override
    public Iterator<Position> positionIterator(Position pos) {
        return new KnightPositionIterator(pos);
    }

    /**
     * Gets the start position.
     * 
     * @return the start position
     */
    public Position getStart() {
        return start;
    }

    @Override
    public String toString() {
        // display the summary of all moves
        String result = "\n";

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                result += String.valueOf(grid[row][column]) + ' ';
            }
            result += "\n";
        }
        return result;
    }

}
