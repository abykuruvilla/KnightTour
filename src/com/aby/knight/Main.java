package com.aby.knight;

// TODO: Auto-generated Javadoc
/**
 * Main Class for the Knight Tour Game.
 * 
 * @author Aby
 */

public class Main {

    /** The back track. */
    private BackTracker backTrack;
    /** Indicates a nxn grid. */
    private static int GRIDSIZE = 3;
    /** The startrow. */
    private static int STARTROW;
    /** The startcol. */
    private static int STARTCOL;

    /**
     * Main method to Knight Tour game.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        try {
            STARTROW = Integer.parseInt(args[0]) - 1;
            STARTCOL = Integer.parseInt(args[1]) - 1;
        } catch (NumberFormatException nfe) {
            System.out.println("Exception: Not a valid number "
                    + nfe.getMessage());
        }

        System.out.println("** KNIGHTS TOUR ** \n");
        System.out.println("The size of the grid is : " + GRIDSIZE + "x"
                + GRIDSIZE);
        System.out.println("The starting position of the Knight is : ("
                + (STARTROW + 1) + ", " + (STARTCOL + 1) + ")");

        try {
            new Main().run();
        } catch (Exception e) {
            System.out.println("Error in Processing :" + e.getMessage());
        }
    }

    /**
     * The main run method.
     * 
     * @throws Exception
     *             the exception
     */
    private void run() throws Exception {
        Position startPosition = new Position(STARTROW, STARTCOL);
        Position finalPosition = new Position(2, 2);
        boolean isValid = false;

        // exit if the start position is (1,1), this is a dead end
        if (startPosition.getRow() == 1 && startPosition.getColumn() == 1) {
            System.out.println("ERROR: Position invalid; the Knight is stuck");
            System.out.println("EXITING!!");
            throw new Exception("ERROR: Position invalid");
        }

        // exit if the start position is (2,2), this is the final position
        if (startPosition.equals(finalPosition)) {
            System.out.println("SUCCESS: Final Position Reached");
            System.out.println("EXITING!!");
            System.exit(0);
        }

        while (!isValid) {
            try {
                KnightsMove knight = new KnightsMove(GRIDSIZE, GRIDSIZE,
                        startPosition, finalPosition);
                // check if start position is within the grid
                if (!knight.isPositionOk(knight.start)) {
                    System.out.println("THE START POSITION IS INVALID !!");
                } else {
                    if (searchBoard(knight)) {
                        System.out
                                .println("\n SUCCESS: Goal Position Reached !");
                    } else {
                        System.out.println("FAILURE: Unable to reach Goal !");
                    }
                    System.out
                            .println("\n *** SUMMARY VIEW OF KNIGHTS TOUR ***");
                    System.out.println(knight);
                }
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Exception: Not a valid number "
                        + nfe.getMessage());
            }
        }

    }

    /**
     * Search board for all possible moves.
     * 
     * @param knight
     *            the knight
     * @return true, if successful, else false
     */
    public boolean searchBoard(KnightsMove knight) {

        Position start = knight.getStart();
        knight.markPositionAsPossible(start);
        backTrack = new BackTracker(knight);

        if (knight.isGoalPosition(start)
                || backTrack.isGoalReachedFromPosition(start)) {
            return true;
        }
        knight.markPositionAsDeadEnd(start);
        return false;
    }
}
