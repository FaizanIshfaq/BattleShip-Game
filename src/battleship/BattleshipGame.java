package battleship;

import java.util.Scanner;

public class BattleshipGame {

    public static void main(String[] args) {

        // Create a new ocean object
        Ocean ocean = new Ocean();

        // Randomly place all the ships on the ocean
        ocean.placeAllShipsRandomly();


        // Print the initial state of the ocean
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < 10; row++) {
            System.out.print(row + " ");
            for (int column = 0; column < 10; column++) {
                System.out.print(". ");
            }
            System.out.println();
        }
        ocean.printWithShips();

        // Keep track of the number of shots fired and hits
        int shotsFired = 0;
        int hits = 0;

        // Allow the user to take shots at the ships
        Scanner scanner = new Scanner(System.in);
        while (!ocean.isGameOver()) {
            // Prompt the user for a row and column to shoot
            int row, column;
            int TotalShips = ocean.getShipArray().length;


            do {
                System.out.print("Enter row to shoot (0-9): ");
                row = scanner.nextInt();
                System.out.print("Enter column to shoot (0-9): ");
                column = scanner.nextInt();
            } while (row < 0 || row > 9 || column < 0 || column > 9);

            // Shoot at the specified row and column
            if (ocean.shootAt(row, column)) {
                // The shot hit a ship
                hits++;
                Ship hitShip = ocean.getShipArray()[row][column];
                if (hitShip.isSunk()) {
                    System.out.println("You sank a " + hitShip.getShipType() + "!");
                } else {
                    System.out.println("You hit a " + hitShip.getShipType() + "!");
                }

                int remainingShips = ocean.getShipsSunk();
                if (remainingShips == 1) {
                    System.out.println("There is 1 ship remaining.");
                } else {
                    System.out.println("There are " + remainingShips + " ships destroyed.");
                }
            } else {
                // The shot missed
                System.out.println("You missed.");
            }

            shotsFired++;

            // Print the updated state of the ocean
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 10; j++) {
                    if (ocean.getMark(i, j)) {
                        System.out.print(ocean.getShipArray()[i][j] + " ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
        }

        // Print the final score
        System.out.println("Game over!");
        System.out.println("Shots fired: " + shotsFired);
        System.out.println("Hits: " + hits);
        System.out.println("Accuracy: " + (hits * 100.0 / shotsFired) +
                "%");
    }
}