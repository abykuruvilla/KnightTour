package com.aby.knight;

/**
 * This class will mainly be used to deal with the actual chess board grid. It
 * will be mainly used to access properties of the board and draw the current
 * status of the chess board.
 * 
 * @author Aby
 */
public class Board {

    /** The number of ROWS on the chess board. */
    private static final int NUMROWS = 3;
    /** The number of COLUMNS on the chess board. */
    private static final int NUMCOLUMNS = 3;
    /** The horizontal border. */
    private static final String HBORDER = " ---";
    /** The vertical border. */
    private static final String VBORDER = "|";
    /** The 2D board array. */
    private int[][] board = new int[NUMROWS][NUMCOLUMNS];

    /**
     * Creates a new board and defaults the value of each square/element on the
     * chess board to zero.
     */
    public Board() {
        clearBoard();
    }

    /**
     * Replace value of all squares/elements to zeros.
     */
    public final void clearBoard() {
        for (int row = 0; row < NUMROWS; row++) {
            for (int col = 0; col < NUMCOLUMNS; col++) {
                board[row][col] = 0;
            }
        }
    }

    /**
     * Prints out the current state of the chess board onto the console. The
     * current position of the knight is displayed on the board with an "X"
     * symbol.
     */
    public final void showBoard() {
        System.out.print("\n");
        for (int i = 0; i < NUMROWS; i++) {
            System.out.print(HBORDER);
        }
        System.out.print("\n");
        System.out.print(VBORDER);

        int col = 0;
        for (int row = 0; row < NUMROWS; ++row) {
            for (col = 0; col < NUMCOLUMNS; ++col) {
                if (board[row][col] == -1) {
                    System.out.print(" K ");
                }
                if (board[row][col] == 0) {
                    System.out.print("   ");
                }
                System.out.print(VBORDER);
            }
            System.out.print("\n");
            for (int i = 0; i < NUMROWS; i++) {
                System.out.print(HBORDER);
            }
            System.out.print("\n");
            if (row != NUMCOLUMNS - 1) {
                System.out.print(VBORDER);
            }
        }
    }

    /**
     * Sets the row and column position of the knight on the chess board.
     * 
     * @param newboard
     *            the Board object
     * @param rowPosition
     *            the row position
     * @param colPosition
     *            the column position
     */
    public final void setPosition(final Board newboard, final int rowPosition,
            final int colPosition) {
        newboard.clearBoard();
        int[][] knightPosition = newboard.getBoard();
        knightPosition[rowPosition][colPosition] = -1;
        newboard.setBoard(knightPosition);
    }

    /**
     * Gets the board.
     * 
     * @return the 2D board array
     */
    public final int[][] getBoard() {
        return board;
    }

    /**
     * Sets the board.
     * 
     * @param gridArray
     *            the 2D board array to set
     */
    public final void setBoard(final int[][] gridArray) {
        this.board = gridArray;
    }

}
