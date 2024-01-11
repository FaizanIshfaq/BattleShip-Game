// Define the package and class name
package battleship;

// Extend the Ship class to inherit its properties and methods
public class Destroyer extends Ship {

    // Define the length of a Destroyer object as a constant variable
    private static final int LENGTH = 2;

    // Constructor to initialize a Destroyer object with a length of 2
    public Destroyer() {
        super(LENGTH);

        // Initialize instance variables for length and hit
        this.length = 2;
        this.hit = new boolean[2];
    }

    // Method to return the type of the ship as a string
    @Override
    public String getShipType() {
        return "destroyer";
    }
}
