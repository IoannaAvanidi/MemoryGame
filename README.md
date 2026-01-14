# Memory Game (Java)

A Java implementation of the classic Memory card game, developed as part of the "Object-Oriented Programming Techniques" course.

## 🎮 Game Description
The game consists of $2N$ cards forming $N$ pairs of numbers from $0$ to $N-1$.
* **Objective:** Players flip two cards per turn trying to find matching pairs.
* **Rules:** If the cards match, the player earns a point and the cards are removed from the board. If they don't match, the cards are flipped back over, and the turn passes to the next player.
* **Game End:** The game ends when all pairs have been found. The player with the highest score wins.

## 🛠️ Class Structure
The project is built using four main classes:

1.  **`Board`**: Manages the game board and the cards using a one-dimensional integer array.
2.  **`HumanPlayer`**: Handles the logic for a human player, including input validation.
3.  **`ComputerPlayer`**: Implements the AI strategy, where the computer "remembers" the positions of cards revealed in previous turns.
4.  **`MemoryGame`**: Contains the `main` method and coordinates the game flow, supporting Human vs. Human or Human vs. Computer modes.

## 🚀 Features & Functionality
* **Random Shuffling:** Cards are placed in a random order on the board at the start of each game.
* **Flash Mechanism:** Briefly reveals the selected cards before they are hidden again.
* **Input Management:** Ensures players can only select valid positions that still contain cards.
* **AI Memory:** The computer stores the last known position of each number to make strategic moves in future turns.

## 📋 Execution Instructions
The program accepts the number of pairs as a command-line argument.

```bash
javac Board.java HumanPlayer.java ComputerPlayer.java MemoryGame.java
java MemoryGame [number_of_pairs]
