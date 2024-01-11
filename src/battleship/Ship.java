package battleship;

// Declare the Ship class as an abstract class
public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    int length;
    private boolean horizontal;
    boolean[] hit;

    // Declare the constructor for the Ship class
    public Ship(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Ship length must be positive.");
        }
        this.length = length;
        this.hit = new boolean[length];
    }

    // Declare the shootAt method which takes two integer arguments
    public int getLength() {

        return length;
    }

    // Declare the isSunk method which returns a boolean value
    public int getBowRow() {
        return bowRow;
    }

    // Declare the getShipType method which returns a string value
    public void setBowRow(int row) {
        if (row < 0 || row >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Row must be between 0 and " + (Ocean.OCEAN_SIZE - 1));
        }
        this.bowRow = row;
    }

    // Declare the okToPlaceShipAt method which takes four arguments
    public int getBowColumn() {
        return bowColumn;
    }

    // Declare the placeShipAt method which takes four arguments
    public void setBowColumn(int column) {
        if (column < 0 || column >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Column must be between 0 and " + (Ocean.OCEAN_SIZE - 1));
        }
        this.bowColumn = column;
    }

    // Declare the shootAt method which takes two integer arguments
    public boolean isHorizontal() {
        return horizontal;
    }

    // Declare the isSunk method which returns a boolean value
    public void setHorizontal(boolean horizontal) {

        this.horizontal = horizontal;
    }

    // Declare the getShipType method which returns a string value
    public boolean[] getHit() {
        return hit;
    }

    // Declare the okToPlaceShipAt method which takes four arguments
    public abstract String getShipType();

    // Declare the placeShipAt method which takes four arguments
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        // Check if the ship will go out of the ocean
        if (row < 0 || row >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Invalid row value: " + row);
        }
        if (column < 0 || column >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Invalid column value: " + column);
        }
        if (ocean == null) {
            throw new NullPointerException("Ocean cannot be null.");
        }
        if (horizontal) {
            if (column + length > Ocean.OCEAN_SIZE) {
                return false;
            }
        } else {
            if (row + length > Ocean.OCEAN_SIZE) {
                return false;
            }
        }

        // Check if the ship overlaps or touches another ship
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < Ocean.OCEAN_SIZE && j >= 0 && j < Ocean.OCEAN_SIZE) {
                    if (ocean.isOccupied(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Declare the shootAt method which takes two integer arguments
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (ocean == null) {
            throw new NullPointerException("Ocean cannot be null.");
        }
        setBowRow(row);
        setBowColumn(column);
        setHorizontal(horizontal);
        for (int i = 0; i < length; i++) {
            if (horizontal) {
                ocean.ships[row][column + i] = this;
            } else {
                ocean.ships[row + i][column] = this;
            }
        }
    }

    // Declare the isSunk method which returns a boolean value
    public boolean shootAt(int row, int column) {
        if (row < 0 || row >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Invalid row value: " + row);
        }
        if (column < 0 || column >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Invalid column value: " + column);
        }
        if (hit == null) {
            throw new NullPointerException("Hit array cannot be null.");
        }
        if (hit.length != length) {
            throw new IllegalStateException("Hit array length must be equal to ship length.");
        }
        if (isSunk()) {
            return false;
        }
        if (horizontal) {
            if (row != bowRow) {
                return false;
            }
            int offset = column - bowColumn;
            if (offset < 0 || offset >= length) {
                return false;
            }
            hit[offset] = true;
        } else {
            if (column != bowColumn) {
                return false;
            }
            int offset = row - bowRow;
            if (offset < 0 || offset >= length) {
                return false;
            }
            hit[offset] = true;
        }
        return true;
    }

    // Declare the getShipType method which returns a string value
    public boolean isSunk() {
        if (hit == null) {
            throw new NullPointerException("Hit array cannot be null.");
        }
        if (hit.length != length) {
            throw new IllegalStateException("Hit array length must be equal to ship length.");
        }

        for (boolean b : hit) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
    // Declare the okToPlaceShipAt method which takes four arguments

    @Override
    public String toString() {
        return isSunk() ? "s" : "x";
    }

    // Declare the placeShipAt method which takes four arguments
    public boolean isHit(int row, int col) {
        if (row < 0 || row >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Invalid row value: " + row);
        }
        if (col < 0 || col >= Ocean.OCEAN_SIZE) {
            throw new IllegalArgumentException("Invalid column value: " + col);
        }
        if (hit == null) {
            throw new NullPointerException("Hit array cannot be null.");
        }
        if (hit.length != length) {
            throw new IllegalStateException("Hit array length must be equal to ship length.");
        }

        if (horizontal) {
            int colOffset = col - bowColumn;
            if (row == bowRow && colOffset >= 0 && colOffset < length) {
                return hit[colOffset];
            }
        } else {
            int rowOffset = row - bowRow;
            if (col == bowColumn && rowOffset >= 0 && rowOffset < length) {
                return hit[rowOffset];
            }
        }
        return false;
    }

}

