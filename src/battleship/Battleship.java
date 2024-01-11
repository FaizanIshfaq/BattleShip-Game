// Define the package and class name
package battleship;

// Extend the Ship class to inherit its properties and methods
public class Battleship extends Ship {

    // Define the length of a Battleship object as a constant variable
    private static final int LENGTH = 4;

    // Constructor to initialize a Battleship object with a length of 4
    public Battleship() {
        super(LENGTH);
    }

    // Method to return the type of the ship as a string
    @Override
    public String getShipType() {
        return "battleship";
    }
}
