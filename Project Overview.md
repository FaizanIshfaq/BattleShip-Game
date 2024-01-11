# BattleShip-Game

Main Class (main):

Displays a grid (10x10) to represent the game board.
Initializes an Ocean object and places ships randomly on the board.
Allows the user to take shots at the ships until all ships are sunk.
Prints the final score and game statistics.
Ship Classes (Battleship, Cruiser, Destroyer, Submarine, EmptySea):

Battleship, Cruiser, and Destroyer are specific ship types, each inheriting from the abstract Ship class.
Submarine is a special case of a ship.
EmptySea represents an empty space on the game board.
Ocean Class (Ocean):

Represents the game board and manages ship placement.
Randomly places ships on the board using the placeAllShipsRandomly method.
Keeps track of shots fired, hits, and sunk ships.
Provides methods for shooting at a location, checking if a location is occupied, and determining if the game is over.
Includes methods to print the board with or without showing ship locations.
Abstract Ship Class (Ship):

An abstract class that serves as the base class for all ship types.
Contains common properties and methods for ships.
Includes methods for placing a ship on the board, shooting at a location, and checking if the ship is sunk.
Subclasses of Ship:

Battleship, Cruiser, Destroyer, and Submarine extend the Ship class, each implementing its specific ship type behavior.
User Interaction (BattleshipGame):

The main method of BattleshipGame class interacts with the user.
Prompts the user to input row and column coordinates to take shots at the ships.
Prints feedback on hits, misses, and sunk ships.
