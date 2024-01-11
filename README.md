# BattleShip-Game

Main Game Logic (main):

The game starts by showing a 10x10 grid representing the ocean.
It randomly places different types of ships on the board.
Users take turns guessing coordinates to sink the hidden ships until they've found them all.
The final score and game statistics are displayed.
Types of Ships (Battleship, Cruiser, Destroyer, Submarine, EmptySea):

There are different types of ships, like Battleships, Cruisers, and Destroyers, each inheriting common features from the abstract Ship class.
There's a special type called Submarine.
Empty spaces on the board are represented by EmptySea.
Game Board (Ocean):

Manages the game board, placing ships randomly.
Keeps track of shots fired, hits, and sunk ships.
Users can shoot at specific locations on the board, and the game provides feedback on hits and misses.
Methods are available to print the board, either showing or hiding ship locations.
Base Ship Class (Ship):

The abstract base class for all ship types.
Includes common properties and methods for all ships, like placing them on the board and determining if they're sunk.
User Interaction (BattleshipGame):

The BattleshipGame class handles user interactions.
Players input row and column coordinates to take shots at the ships.
The game gives feedback on hits, misses, and when a ship is sunk.
