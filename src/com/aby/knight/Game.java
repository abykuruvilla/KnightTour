package com.aby.knight;

import java.util.Iterator;

/**
 * The Game interface will be implemented by the Knight Tour game. It provides
 * methods which are generalizations to implement backtracking. It uses the
 * iterator pattern to access positions available from a given position
 * 
 * @author Aby
 * 
 */

public interface Game {

    /**
     * Determines if a given move by chess piece is a legal move.
     * 
     * @param pos
     *            the given position
     * @return true if the position is legal, false if position is illegal
     */
    boolean isPositionOk(Position pos);

    /**
     * Indicates that a given position is possible on the path to a goal
     * 
     * @param pos
     *            the position marked possible on path to goal
     */
    void markPositionAsPossible(Position pos);

    /**
     * Determines if the position provided is the goal position
     * 
     * @param pos
     *            The position that needs to be checked for being a goal
     *            position
     * @return true if position is a goal position, false if position is not a
     *         goal position
     */
    boolean isGoalPosition(Position pos);

    /**
     * Marks a given position as not on the path to the goal
     * 
     * @param pos
     *            the position that needs to be marked as a dead end
     */
    void markPositionAsDeadEnd(Position pos);

    /**
     * Convert the Game object to a String
     * 
     * @return String representation of a Game object
     */
    String toString();

    /**
     * Produces an Iterator object that starts at a given position
     * 
     * @param pos
     *            the starting position of the Iterator
     * @return an Iterator object that accesses the positions from the given
     *         starting position
     */
    Iterator<Position> positionIterator(Position pos);

}