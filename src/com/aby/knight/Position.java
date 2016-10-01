package com.aby.knight;

/**
 * The Position class just determines the position (row,column) of the chess
 * piece on the Chess Borad
 * 
 * @author Aby
 * 
 */

public class Position {

    protected int row;
    protected int column;

    /**
     * Default constructor that initializes this Position object to (0, 0).
     */
    public Position() {
        row = 0;
        column = 0;
    }

    /**
     * Initializes the Position object to (row, column) specified.
     * 
     * @param initRow
     *            the row the Position object will be initialized to.
     * @param initColumn
     *            the column the Position object will be initialized to.
     */
    public Position(final int initRow, final int initColumn) {
        this.row = initRow;
        this.column = initColumn;
    }

    /**
     * Gets the row of the Position object.
     * 
     * @return the row of this Position object.
     */
    public final int getRow() {
        return row;
    }

    /**
     * Gets the column of the Position object.
     * 
     * @return the column of this Position object.
     */
    public final int getColumn() {
        return column;
    }

    /*
     * HashCode Implementation
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    /*
     * New equals implementation for position comparison
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        if (column != other.column) {
            return false;
        }
        if (row != other.row) {
            return false;
        }
        return true;
    }

}
