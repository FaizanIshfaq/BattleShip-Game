// Declare the package name
package battleship;

// Declare the Submarine class which extends the Ship class
public class Submarine extends Ship {

    // Declare a constant variable for the length of the submarine
    private static final int LENGTH = 1;

    // Declare the constructor for the Submarine class
    public Submarine() {
        // Call the constructor of the Ship class with the length of the submarine as an argument
        super(LENGTH);
    }

    // Override the getShipType method from the Ship class to return the type of ship as "submarine"
    @Override
    public String getShipType() {
        return "submarine";
    }
}
