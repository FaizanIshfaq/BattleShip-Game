package battleship;

import java.util.Random;

public class Ocean {
    // Declare the instance variables

    public static final int OCEAN_SIZE = 10;
    Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    // Constructor to initialize the Ocean with empty sea
    public Ocean() {
        ships = new Ship[10][10];
        // Populate the array with EmptySea objects
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                ships[row][col] = new EmptySea();
            }
        }
        // Initialize instance variables for shotsFired, hitCount, and shipsSunk
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
    }

    // Method to randomly place all the ships on the Ocean
    public void placeAllShipsRandomly() {
        Random rand = new Random();
        // Declare an array of ship lengths in descending order
        int[] shipLengths = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        for (int len : shipLengths) {
            boolean shipPlaced = false;
            while (!shipPlaced) {
                int row = rand.nextInt(10);
                int col = rand.nextInt(10);
                boolean horizontal = rand.nextBoolean();
                Ship newShip;
                if (len == 1) {
                    newShip = new Submarine();
                } else if (len == 2) {
                    newShip = new Destroyer();
                } else if (len == 3) {
                    newShip = new Cruiser();
                } else {
                    newShip = new Battleship();
                }
                if (newShip.okToPlaceShipAt(row, col, horizontal, this)) {
                    newShip.placeShipAt(row, col, horizontal, this);
                    shipPlaced = true;
                }
            }
        }
    }
    // Method to check if a given location on the Ocean is occupied by a ship
    public boolean isOccupied(int row, int col) {
        return ships[row][col].getShipType() != "empty";
    }
    // Method to shoot at a given location on the Ocean
    public boolean shootAt(int row, int col) {
        shotsFired++;
        // Check if the shot hits a ship
        if (ships[row][col].shootAt(row, col)) {
            hitCount++;
            // Check if the ship is sunk
            if (ships[row][col].isSunk()) {
                shipsSunk++;
            }
            return true;
        } else {
            return false;
        }
    }
// Returns the number of shots fired by the player
    public int getShotsFired() {
        return shotsFired;
    }
// Returns the number of successful hits by the player
    public int getHitCount() {
        return hitCount;
    }
// Returns the number of ships sunk by the player
    public int getShipsSunk() {
        return shipsSunk;
    }
// Returns true if all 10 ships have been sunk, indicating the end of the game
    public boolean isGameOver() {
        return shipsSunk == 10;
    }
// Returns the 10x10 array of ships
    public Ship[][] getShipArray() {
        return ships;
    }
// Prints the game board with row and column labels and indicates hit or miss for each square
    public void print() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < 10; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 10; col++) {
                if (ships[row][col].isHit(row, col)) {
                    System.out.print(ships[row][col] + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // Method to return the ship at a given location on the Ocean
    public boolean getMark(int i, int j) {
        return ships[i][j].isHit(i, j);
    }
    //This method is useful for testing purposes, as it allows the player to see where their ships are located on the board.
    public void printWithShips() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < 10; row++) {
            System.out.print(row + " ");
            for (int column = 0; column < 10; column++) {
                Ship ship = ships[row][column];
                if (ship instanceof EmptySea) {
                    System.out.print("  ");
                } else if (ship instanceof Submarine) {
                    System.out.print("s ");
                } else if (ship instanceof Destroyer) {
                    System.out.print("d ");
                } else if (ship instanceof Cruiser) {
                    System.out.print("c ");
                } else if (ship instanceof Battleship) {
                    System.out.print("b ");
                }
            }
            System.out.println();
        }
    }

}
