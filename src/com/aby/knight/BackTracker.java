package com.aby.knight;

import java.util.Iterator;

/**
 * The Backtracker class will be used to backtrack the Knight when it reaches a
 * square on a chess board which has already been visited. The two main
 * responsibilities of this class are two initialize a given Game Object and to
 * try to reach a goal position from a given position.
 * 
 * @author Aby
 * 
 */

public class BackTracker {

    /** The game object. */
    protected Game game;

    /**
     * Initializes a Backtracker object from a Game.
     * 
     * @param newGame
     *            The Game
     */
    public BackTracker(Game newGame) {
        this.game = newGame;
    }

    /**
     * Attempts to reach a goal position from a given position
     * 
     * @param pos
     *            the given position
     * @return true if attempt to reach goal succeeds false if attempt is not
     *         successful
     */
    public boolean isGoalReachedFromPosition(Position pos) {
        Iterator<Position> itr = game.positionIterator(pos);

        while (itr.hasNext()) {
            // the position may be on the path to a goal
            pos = itr.next();
            if (game.isPositionOk(pos)) {
                game.markPositionAsPossible(pos);
                if (game.isGoalPosition(pos) || isGoalReachedFromPosition(pos)) {
                    return true;
                }
                game.markPositionAsDeadEnd(pos);
            }
        }
        return false;
    }

}
