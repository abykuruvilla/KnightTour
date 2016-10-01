package com.aby.knight;

import java.util.Iterator;

/**
 * An Iterator implementation for all possible positions that a Knight can visit
 * on the board.
 * 
 * @author Aby
 * 
 */

public class KnightPositionIterator implements Iterator<Position> {

    /** The row. */
    private int row;
    /** The col. */
    private int col;
    /** The counter. */
    private int counter;

    /**
     * Instantiates a new knight position iterator to start at the given
     * position.
     * 
     * @param pos
     *            the position
     */
    public KnightPositionIterator(Position pos) {
        row = pos.getRow();
        col = pos.getColumn();
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < 8;
    }

    @Override
    public Position next() {
        Position nextPosition = new Position();
        switch (counter++) {

        case 0:
            nextPosition = new Position(row - 2, col + 1);
            break;
        case 1:
            nextPosition = new Position(row - 1, col + 2);
            break;
        case 2:
            nextPosition = new Position(row + 1, col + 2);
            break;
        case 3:
            nextPosition = new Position(row + 2, col + 1);
            break;
        case 4:
            nextPosition = new Position(row + 2, col - 1);
            break;
        case 5:
            nextPosition = new Position(row + 1, col - 2);
            break;
        case 6:
            nextPosition = new Position(row - 1, col - 2);
            break;
        case 7:
            nextPosition = new Position(row - 2, col - 1);
            break;
        default:
            break;
        }
        return nextPosition;
    }

    @Override
    public void remove() {
        // unsupported
        System.out.println("UNSUPPORTED!!!");
        throw new UnsupportedOperationException(
                "Unsupported Remove Operation!!!");

    }

}
