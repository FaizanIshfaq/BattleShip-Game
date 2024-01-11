// Define the package and class name
package battleship;

// Extend the Ship class to inherit its properties and methods
public class Cruiser extends Ship {

    // Define the length of a Cruiser object as a constant variable
    private static final int LENGTH = 3;

    // Constructor to initialize a Cruiser object with a length of 3
    public Cruiser() {
        super(LENGTH);
    }

    // Method to return the type of the ship as a string
    @Override
    public String getShipType() {
        return "cruiser";
    }
}
