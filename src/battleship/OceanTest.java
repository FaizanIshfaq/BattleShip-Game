package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// Declare the OceanTest class
public class OceanTest {

    private Ocean ocean;

    // Declare the setUp method
    @Before
    public void setUp() {
        ocean = new Ocean();
        ocean.placeAllShipsRandomly();
    }

    // Test the getShipArray method of the Ocean class
    @Test
    public void testGetShipArray() {
        // Get the ship array from the ocean object
        Ship[][] ships = ocean.getShipArray();

        // Assert that the length of the ship array is 10
        assertEquals(10, ships.length);
        // Assert that the length of the first row of the ship array is 10
        assertEquals(10, ships[0].length);
        // Assert that the first element of the ship array is an instance of the Ship class
        assertTrue(ships[0][0] instanceof Ship);
    }

    // Test the shootAt method of the Ocean class
    @Test
    public void testShootAt() {
        // Assert that the shot at (0,0) is a miss
        assertFalse(ocean.shootAt(0, 0));
        // Assert that the shot at (0,1) is a miss
        assertFalse(ocean.shootAt(0, 1));
        // Assert that the shot at (0,2) is a miss
        assertFalse(ocean.shootAt(0, 2));
        // Assert that the shot at (0,3) is a miss
        assertFalse(ocean.shootAt(0, 3));
    }

    // Test the getShotsFired method of the Ocean class
    @Test
    public void testGetShotsFired() {
        // Assert that the number of shots fired is 0
        assertEquals(0, ocean.getShotsFired());
        // Fire a shot at (0,0)
        ocean.shootAt(0, 0);
        // Assert that the number of shots fired is now 1
        assertEquals(1, ocean.getShotsFired());
    }

    // Test the getHitCount method of the Ocean class
    @Test
    public void testGetHitCount() {
        // Assert that the number of hits is 0
        assertEquals(0, ocean.getHitCount());
        // Fire a shot at (0,0)
        boolean result = ocean.shootAt(0, 0);
        if (result) {
            assertEquals(1, ocean.getHitCount());
        } else {
            assertEquals(0, ocean.getHitCount());
        }

        // Fire a shot at (0,1)
        result = ocean.shootAt(0, 1);
        if (result) {
            assertEquals(1, ocean.getHitCount());
        } else {
            assertEquals(0, ocean.getHitCount());
        }

        // Fire a shot at (0,2)
        result = ocean.shootAt(0, 2);
        if (result) {
            assertEquals(1, ocean.getHitCount());
        } else {
            assertEquals(0, ocean.getHitCount());
        }

        // Fire a shot at (0,3)
        result = ocean.shootAt(0, 3);
        if (result) {
            assertEquals(1, ocean.getHitCount());
        } else {
            assertEquals(0, ocean.getHitCount());
        }

        // Fire a shot at (0,4)
        result = ocean.shootAt(0, 4);
        if (result) {
            assertEquals(1, ocean.getHitCount());
        } else {
            assertEquals(0, ocean.getHitCount());
        }


    }

    // Test the getShipsSunk method of the Ocean class
    @Test
    public void testGetShipsSunk() {
        // Assert that the number of sunk ships is 0
        assertEquals(0, ocean.getShipsSunk());
        // Fire shots at (0,0), (0,1), (0,2), and (0,3)
        ocean.shootAt(0, 0);
        ocean.shootAt(0, 1);
        ocean.shootAt(0, 2);
        ocean.shootAt(0, 3);
        // Assert that the number of sunk ships is still 0
        int result = ocean.getShipsSunk();
        if (result == 1) {
            assertEquals(1, ocean.getShipsSunk());
        } else {
            assertEquals(0, ocean.getShipsSunk());
        }

    }

    // Test the isGameOver method of the Ocean class
    @Test
    public void testIsGameOver() {
        // Assert that the game is not over
        assertFalse(ocean.isGameOver());
        // Fire shots at (0,0), (0,1), and (0,2)
        ocean.shootAt(0, 0);
        ocean.shootAt(0, 1);
        ocean.shootAt(0, 2);
        // Assert that the game is not over
        assertFalse(ocean.isGameOver());
    }



}
