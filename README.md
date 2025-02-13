# Blackjack Game in Java

## Description  
This is a simple Blackjack game implemented in Java. The game follows the basic rules of Blackjack, where the player and the dealer are each dealt two cards. The player can choose to "hit" to receive additional cards or "stay" to keep their current hand. The goal is to get as close to 21 as possible without going over. The dealer follows a set of rules to determine whether to hit or stay.

---

## Features  
- **Rules Display**: The game starts by displaying the rules of Blackjack.  
- **Card Dealing**: The player and dealer are each dealt two cards initially.  
- **Hit or Stay**: The player can choose to hit or stay based on their current hand value.  
- **Dealer's Turn**: The dealer reveals their second card and follows a set of rules to hit or stay.  
- **Next Level**: After each round, the player can choose to play the next level or exit the game.  
- **Winning Conditions**: The game determines the winner based on the hand values of the player and the dealer.  

---

## How to Play  
1. **Run the Game**: Compile and run the `Game.java` file.  
2. **Read the Rules**: The game will display the rules of Blackjack.  
3. **Initial Deal**: The player and dealer are each dealt two cards. The player can see one of the dealer's cards.  
4. **Hit or Stay**: The player can choose to hit (receive another card) or stay (keep their current hand).  
5. **Dealer's Turn**: After the player's turn, the dealer reveals their second card and hits or stays based on the rules.  
6. **Determine Winner**: The game compares the hand values of the player and the dealer to determine the winner.  
7. **Next Level**: After each round, the player can choose to play the next level or exit the game.
   # Step 1: Starting the Game
   ![Starting the Game](https://github.com/BitByBit-05/BlackJack_Game/blob/9499ae3cf311e79a2de1fd484ddafb2256e70da7/Screenshot%202025-02-02%20011125.png)
   # Step 2: Making Moves**
   ![Making Moves](https://github.com/BitByBit-05/BlackJack_Game/blob/0f596df76346a6c772a755a0e79a5c7abb989574/Screenshot%202025-02-02%20011021.png
)

---

## Code Structure  
- **`Rules()`**: Displays the rules of the game.  
- **`getRandomCard(int PlayerCardcount)`**: Generates a random card value for the player or dealer.  
- **`Level2()`**: Prompts the player to choose whether to play the next level or exit the game.  
- **`initialDeal(int[] playerCards, int[] dealerCards, int PlayerCardcount, int DealerCardcount)`**: Deals the initial two cards to the player and dealer.  
- **`getHandValueP(int[] playerCards, int PlayerCardcount)`**: Calculates the total value of the player's hand.  
- **`getHandValueD(int[] dealerCards, int DealerCardcount)`**: Calculates the total value of the dealer's hand.  
- **`determineWinner(int[] playerCards, int[] dealerCards, int PlayerCardcount, int DealerCardcount)`**: Determines the winner based on the hand values.  
- **`main(String[] args)`**: The main method that runs the game.  

---

## Requirements  
- Java Development Kit (JDK) installed on your machine.  
- A Java IDE or command-line interface to compile and run the code.  

---

## Acknowledgements  
- I developed this project in grade 11 to apply and expand my Java programming skills. 
- Inspired by the classic card game Blackjack.
