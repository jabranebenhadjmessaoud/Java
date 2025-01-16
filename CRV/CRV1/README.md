# Game Development Assignment

## Objective

Create a simple text-based game where a player controls a fighter and battles against an enemy. The game continues until one character's health reaches zero. The player can choose to play again after each round.

## Tasks

### 1. Create the `Attack` Class

- Create a class named `Attack` with the following properties:
  - `name` (String): The name of the attack.
  - `damageAmount` (int): The amount of damage the attack deals (must be between 5 and 25).
- Implement a constructor to initialize the properties.
- Implement getter methods for both properties.

### 2. Create the `Enemy` Class

- Create a class named `Enemy` with the following properties:
  - `name` (String): The name of the enemy.
  - `health` (int): The health of the enemy (default to 100).
  - `attackList` (ArrayList<Attack>): A list of attacks the enemy can use.
- Implement a constructor to initialize the `name` and `health` properties and initialize the `attackList`.
- Implement the following methods:
  - `getName()`: Returns the name of the enemy.
  - `getHealth()`: Returns the health of the enemy.
  - `displayAttacks()`: Displays the list of attacks.
  - `addAttack(Attack attack)`: Adds an attack to the `attackList`.
  - `randomAttack(Fighter fighter)`: Performs a random attack on the fighter.
  - `reduceHealth(int amount)`: Reduces the health of the enemy by the specified amount.

### 3. Create the `Fighter` Class

- Create a class named `Fighter` with the following properties:
  - `name` (String): The name of the fighter.
  - `health` (int): The health of the fighter (default to 120).
  - `attackList` (ArrayList<Attack>): A list of attacks the fighter can use.
- Implement a constructor to initialize the `name` and `health` properties and add three default attacks (`Punch`, `Kick`, `Tackle`).
- Implement the following methods:
  - `getName()`: Returns the name of the fighter.
  - `getHealth()`: Returns the health of the fighter.
  - `displayAttacks()`: Displays the list of attacks.
  - `attack(int index, Enemy enemy)`: Performs an attack on the enemy based on the index of the attack in the `attackList`.
  - `reduceHealth(int amount)`: Reduces the health of the fighter by the specified amount.

### 4. Create the `TestGame` Class

- Create a class named `TestGame` with a `main` method to run the game.
- Implement the following steps in the `main` method:
  - Welcome the player to the game.
  - Prompt the player to enter a name for their fighter and create an instance of `Fighter`.
  - Create an instance of `Enemy` with the name "Goblin".
  - Create three instances of `Attack` and add them to the enemy.
  - Implement the game loop where the player and enemy take turns attacking each other until one character's health reaches zero.
  - After each round, ask the player if they want to play again. If yes, restart the game. If no, end the game.

### 5. Testing

- Test the game by running the `TestGame` class and ensuring that the game behaves as expected.
- Verify that the player can choose attacks, the enemy attacks randomly, and the health of both characters is updated correctly.
- Ensure that the game loop continues until one character's health reaches zero and that the player can choose to play again.
