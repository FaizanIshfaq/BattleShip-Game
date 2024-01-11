package battleship;

import static org.junit.Assert.*;
        import org.junit.Before;
        import org.junit.Test;

public class ShipTest {
    private Ship ship;

    @Before
    public void setUp() {
        ship = new Submarine();
    }

    // Test the Battleship constructor and methods
    @Test
    public void testBattleship() {
        // Create a new Battleship object
        Ship battleship = new Battleship();
        // Assert that the Battleship has length 4
        assertEquals(4, battleship.getLength());
        // Assert that the Battleship's ship type is "battleship"
        assertEquals("battleship", battleship.getShipType());
    }

    // Test the Cruiser constructor and methods
    @Test
    public void testCruiser() {
        // Create a new Cruiser object
        Ship cruiser = new Cruiser();
        // Assert that the Cruiser has length 3
        assertEquals(3, cruiser.getLength());
        // Assert that the Cruiser's ship type is "cruiser"
        assertEquals("cruiser", cruiser.getShipType());
    }

    // Test the Destroyer constructor and methods
    @Test
    public void testDestroyer() {
        // Create a new Destroyer object
        Ship destroyer = new Destroyer();
        // Assert that the Destroyer has length 2
        assertEquals(2, destroyer.getLength());
        // Assert that the Destroyer's ship type is "destroyer"
        assertEquals("destroyer", destroyer.getShipType());
    }

    // Test the getShipType method of the Ship class
    @Test
    public void testGetShipType() {
        // Assert that the Submarine's ship type is "submarine"
        assertEquals("submarine", ship.getShipType());
    }

    // Test the getLength method of the Ship class
    @Test
    public void testGetLength() {
        // Assert that the Submarine's length is 1
        assertEquals(1, ship.getLength());
    }

    // Test the getBowRow method of the Ship class
    @Test
    public void testGetBowRow() {
        // Place the Submarine at (2, 3) vertically
        ship.placeShipAt(2, 3, true, new Ocean());
        // Assert that the Submarine's bow row is 2
        assertEquals(2, ship.getBowRow());
    }

    // Test the getBowColumn method of the Ship class

    @Test
    public void testGetBowColumn() {
        ship.placeShipAt(2, 3, true, new Ocean());
        assertEquals(3, ship.getBowColumn());
    }

    // Test the isHorizontal method of the Ship class

    @Test
    public void testIsHorizontal() {
        ship.placeShipAt(2, 3, true, new Ocean());
        assertTrue(ship.isHorizontal());
    }

    // Test the setBowRow method of the Ship class
    @Test
    public void testSetBowRow() {
        ship.setBowRow(5);
        assertEquals(5, ship.getBowRow());
    }

    // Test the setBowColumn method of the Ship class
    @Test
    public void testSetBowColumn() {
        ship.setBowColumn(6);
        assertEquals(6, ship.getBowColumn());
    }

    // Test the setHorizontal method of the Ship class
    @Test
    public void testSetHorizontal() {
        ship.setHorizontal(false);
        assertFalse(ship.isHorizontal());
    }

    // Test the getHit method of the Ship class
    @Test
    public void testOkToPlaceShipAt() {
        Ocean ocean = new Ocean();
        assertTrue(ship.okToPlaceShipAt(2, 3, true, ocean));
        ship.placeShipAt(2, 3, true, ocean);
        assertFalse(ship.okToPlaceShipAt(2, 3, true, ocean));
    }

    // Test the getHit method of the Ship class
    @Test
    public void testToString() {
        assertEquals("x", ship.toString());
        ship.shootAt(2, 2);
        assertEquals("x", ship.toString());
        ship.placeShipAt(3, 3, true, new Ocean());
        assertEquals("x", ship.toString());
    }

    // Test the getHit method of the Ship class
    @Test
    public void testPlaceShipAt() {
        ship.placeShipAt(3, 3, true, new Ocean());
        assertEquals(3, ship.getBowRow());
        assertEquals(3, ship.getBowColumn());
        assertTrue(ship.isHorizontal());
    }

// Test the getHit method of the Ship class
    @Test
    public void testShootAt() {
        ship.placeShipAt(3, 3, true, new Ocean());
        assertFalse(ship.shootAt(3, 2));
        assertFalse(ship.shootAt(3, 1));
        assertFalse(ship.shootAt(3, 4));
    }



    // Test the getHit method of the Ship class
    @Test
    public void testIsSunk() {
        assertFalse(ship.isSunk());
        ship.placeShipAt(2, 3, true, new Ocean());
        ship.shootAt(2, 3);
        assertTrue(ship.isSunk());
    }

    // Test the getHit method of the Ship class
    @Test
    public void testHitToString() {
        assertEquals("x", ship.toString());
        ship.shootAt(3, 3);
        assertEquals("x", ship.toString());
    }



}