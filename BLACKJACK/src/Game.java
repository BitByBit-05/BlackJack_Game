import java.util.Scanner;
public class Game {
	static Scanner cookie = new Scanner(System.in);
	
	static boolean nextLevel = false;
	
	//rules for the game
	public static void Rules() {
		System.out.println("\r\n"
				+ "██████╗░██╗░░░░░░█████╗░░█████╗░██╗░░██╗░░░░░██╗░█████╗░░█████╗░██╗░░██╗\r\n"
				+ "██╔══██╗██║░░░░░██╔══██╗██╔══██╗██║░██╔╝░░░░░██║██╔══██╗██╔══██╗██║░██╔╝\r\n"
				+ "██████╦╝██║░░░░░███████║██║░░╚═╝█████═╝░░░░░░██║███████║██║░░╚═╝█████═╝░\r\n"
				+ "██╔══██╗██║░░░░░██╔══██║██║░░██╗██╔═██╗░██╗░░██║██╔══██║██║░░██╗██╔═██╗░\r\n"
				+ "██████╦╝███████╗██║░░██║╚█████╔╝██║░╚██╗╚█████╔╝██║░░██║╚█████╔╝██║░╚██╗\r\n"
				+ "╚═════╝░╚══════╝╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝");
		
		System.out.println("\n\nRules of BLACKJACK:");
		System.out.println("1. The player and dealer are each dealt two cards.\r\n"
				+ "2. The player can see one of the dealer's cards, but not both.\r\n"
				+ "3. The player can choose to \"hit\" and be dealt additional cards, one at a time, in order to get closer to 21.\r\n"
				+ "4. The player can choose to \"stay\" and keep their current hand.\r\n"
				+ "5. If the player goes over 21, they automatically lose (this is called \"busting\").\r\n"
				+ "6. After the player stands, the dealer reveals their second card and hits or stands according to a set of rules (usually, the dealer must hit if their total is 16 or less, and stand if their total is 17 or higher)\r\n"
				+ "7. If the dealer busts, the player wins. \r\n"
				+ "8. If the player has a higher total than the dealer (but doesn't bust), the player wins.\n\n");
	}
	
	//random card generator that gives cards to player and dealer
	public static int getRandomCard(int PlayerCardcount) {
	    double chance = Math.random();
	    double holder = 0;
	    
	    if (nextLevel == false) {
	    	holder = 0.05;
	    } 
	    else if(nextLevel == true) {
	    	holder = 0.10;
	    }
	    
	    if (chance < holder) {
	        if (PlayerCardcount + 11 > 21) {
	            return 1;
	        } else {
	            return 11;
	        }
	    } else {
	        return (int) (Math.random() * 10) + 1;
	    }
	}
	
	
	public static void Level2() {
	    String userInput;
	    boolean validInput = false;
	    do {
	        System.out.println("\nWould you like to play Next Level {yes} or {no} ?");
	        userInput = cookie.nextLine();

	        if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no")) {
	            validInput = true;
	        } else {
	            validInput = false;
	            System.out.println("Error: Invalid Input");
	            System.out.println("Would you like to play Next Level {yes} or {no} ?");
	        }

	    } while (validInput != true);

	    if (userInput.equalsIgnoreCase("yes")) {
	        nextLevel = true;
	    } else {
	        nextLevel = false;
	        System.out.println("Thanks for playing!");
	        System.exit(0);
	    }
	}


	
	
	//initial deal in which player get two cards and gets to see one card of dealer but one is hidden
	 public static void initialDeal(int[] playerCards, int[] dealerCards, int PlayerCardcount, int DealerCardcount) {
	        playerCards[PlayerCardcount++] = getRandomCard(PlayerCardcount);
	        dealerCards[DealerCardcount++] = getRandomCard(DealerCardcount);
	        playerCards[PlayerCardcount++] = getRandomCard(PlayerCardcount);
	        dealerCards[DealerCardcount++] = getRandomCard(DealerCardcount);
	        if ((getRandomCard(PlayerCardcount) == 11)&&(PlayerCardcount > 21)){
	        	int v = getRandomCard(PlayerCardcount);
	        	v = 1;
	        }
	        System.out.println("Your cards: " + (playerCards[0]) +", " + playerCards[1]);
	        System.out.println("Dealer's cards: " + dealerCards[0] + " and [hidden]\n");
	        
	        Scanner cookie = new Scanner(System.in);
	        while (getHandValueP(playerCards, PlayerCardcount) < 21) {
	        	System.out.println("Your current hand value is " + getHandValueP(playerCards, PlayerCardcount));
	        	System.out.println("Do you want to hit or stay? (h/s)");
	        	String choice = cookie.nextLine();
	        	if (choice.equals("h")) {
	        		playerCards[PlayerCardcount] = getRandomCard(PlayerCardcount);
	        		PlayerCardcount++;
	        		if (getHandValueP(playerCards, PlayerCardcount) > 21) {
	        			int P = 0;
	        			for (int i = 0; i < playerCards.length; i++) {
	        				if (playerCards[i] > 0) {
	        					P = playerCards[i];
	        					System.out.println("Your cards: " + P);}}
                 System.out.println("Your final hand value is " + getHandValueP(playerCards, PlayerCardcount));
                 break;
             }
         } else if (choice.equals("s")) {
             System.out.println("You stayed. Your final hand value is " + getHandValueP(playerCards, PlayerCardcount));
             break;
         } else {
             System.out.println("\nInvalid choice. Please enter 'h' to hit or 's' to stay.");}}
	        
	        if (nextLevel == true) {
	        	while (getHandValueD(dealerCards, DealerCardcount) < 17) {
		            dealerCards[DealerCardcount++] = getRandomCard(DealerCardcount);
		        }
	        } else {
	        	while (getHandValueD(dealerCards, DealerCardcount) < 11) {
		            dealerCards[DealerCardcount++] = getRandomCard(DealerCardcount);
		        }
	        }
	        
	        System.out.print("\nDealer's cards: ");
	        for (int i = 0; i < DealerCardcount; i++) {
	            System.out.print(dealerCards[i] + " | ");
	        }
	        System.out.println("\nDealer's final hand value is " + getHandValueP(dealerCards, DealerCardcount));}
 
		
	 //HandValue that adds the total of all the card values for the user to decide if to hit or stay
	 public static int getHandValueP(int[] playerCards, int PlayerCardcount) {
		    int handValue = 0;
		    for (int i = 0; i<playerCards.length; i++) {
		        handValue += playerCards[i];}
		    return handValue;
		}
	 
	 //HandValue that adds all the total of DEALER
	 public static int getHandValueD(int[] dealerCards, int DealerCardcount) {
		    int handValue = 0;
		    for (int i = 0; i<dealerCards.length; i++) {
		        handValue += dealerCards[i];}
		    return handValue;
		}
	 
	 public static void determineWinner(int[] playerCards, int[] dealerCards, int PlayerCardcount, int DealerCardcount) {
	        int playerValue = getHandValueP(playerCards, PlayerCardcount);
	        int dealerValue = getHandValueP(dealerCards, DealerCardcount);

	        if (playerValue > 21) {
	            System.out.println("\r\n"
	            		+ "█████████████████████████████████████████████████████████████████████████████████████\r\n"
	            		+ "█▄─▄─▀█▄─██─▄█─▄▄▄▄█─▄─▄─█▄─▄▄─█▄─▄▄▀█░███▄─█─▄█─▄▄─█▄─██─▄███▄─▄███─▄▄─█─▄▄▄▄█▄─▄▄─█\r\n"
	            		+ "██─▄─▀██─██─██▄▄▄▄─███─████─▄█▀██─██─█▄████▄─▄██─██─██─██─█████─██▀█─██─█▄▄▄▄─██─▄█▀█\r\n"
	            		+ "▀▄▄▄▄▀▀▀▄▄▄▄▀▀▄▄▄▄▄▀▀▄▄▄▀▀▄▄▄▄▄▀▄▄▄▄▀▀▄▀▀▀▀▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▀▀▀▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀");
	            Game.Level2();

	           
	            
	            
	            
	        } else if (dealerValue > 21) {
	            System.out.println("\r\n"
	            		+ "██████████████████████████████████████████████████████████████████████████████████████████████\r\n"
	            		+ "█▄─▄▄▀█▄─▄▄─██▀▄─██▄─▄███▄─▄▄─█▄─▄▄▀███▄─▄─▀█▄─██─▄█─▄▄▄▄█─▄─▄─█─▄▄▄▄█░█████▄─█─▄█─▄▄─█▄─██─▄█\r\n"
	            		+ "██─██─██─▄█▀██─▀─███─██▀██─▄█▀██─▄─▄████─▄─▀██─██─██▄▄▄▄─███─███▄▄▄▄─█▄██████▄─▄██─██─██─██─██\r\n"
	            		+ "▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▄▀▀▀▄▄▄▄▀▀▄▄▄▄▄▀▀▄▄▄▀▀▄▄▄▄▄▀▄▀▀▀▀▀▀▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▀▀\r\n"
	            		+ "███████████████████████\r\n"
	            		+ "█▄─█▀▀▀█─▄█▄─▄█▄─▀█▄─▄█\r\n"
	            		+ "██─█─█─█─███─███─█▄▀─██\r\n"
	            		+ "▀▀▄▄▄▀▄▄▄▀▀▄▄▄▀▄▄▄▀▀▄▄▀");
	            Game.Level2();

	            
	            
	            
	        } 
	        else if (playerValue == 21) {
	        	int P = 0;
    			for (int i = 0; i < playerCards.length; i++) {
    				if (playerCards[i] > 0) {
    					P = playerCards[i];
    					System.out.println("Your cards: " + P);}}
         System.out.println("Your final hand value is " + getHandValueP(playerCards, PlayerCardcount));
	        	System.out.println("\r\n"
	        			+ "███████████████████████████████████████████████████████████████\r\n"
	        			+ "█▄─▄─▀█▄─▄████▀▄─██─▄▄▄─█▄─█─▄███▄─▄██▀▄─██─▄▄▄─█▄─█─▄█░█░█░█░█\r\n"
	        			+ "██─▄─▀██─██▀██─▀─██─███▀██─▄▀██─▄█─███─▀─██─███▀██─▄▀██▄█▄█▄█▄█\r\n"
	        			+ "▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▀▀▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▀▄▄▀▄▀▄▀▄▀▄▀");
	        }

	       
            
            
	        else if (dealerValue == 21) {
	        	System.out.println("\r\n"
	        			+ "█████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
	        			+ "█▄─▄▄▀█▄─▄▄─██▀▄─██▄─▄███▄─▄▄─█▄─▄▄▀███▄─▄─▀█▄─▄████▀▄─██─▄▄▄─█▄─█─▄███▄─▄██▀▄─██─▄▄▄─█▄─█─▄█████\r\n"
	        			+ "██─██─██─▄█▀██─▀─███─██▀██─▄█▀██─▄─▄████─▄─▀██─██▀██─▀─██─███▀██─▄▀██─▄█─███─▀─██─███▀██─▄▀██░░██\r\n"
	        			+ "▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▀▀▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▀▄▄▀▀▄▀▀\r\n"
	        			+ "████████████████████████████████████████████████████████████████████████████████████████████\r\n"
	        			+ "█▄─▄─▀█▄─▄▄─█─▄─▄─█─▄─▄─█▄─▄▄─█▄─▄▄▀███▄─▄███▄─██─▄█─▄▄▄─█▄─█─▄███▄─▀█▄─▄█▄─▄▄─█▄─▀─▄█─▄─▄─█\r\n"
	        			+ "██─▄─▀██─▄█▀███─█████─████─▄█▀██─▄─▄████─██▀██─██─██─███▀██─▄▀█████─█▄▀─███─▄█▀██▀─▀████─███\r\n"
	        			+ "▀▄▄▄▄▀▀▄▄▄▄▄▀▀▄▄▄▀▀▀▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▀▀▄▄▀▄▄▄▄▄▀▄▄█▄▄▀▀▄▄▄▀▀\r\n"
	        			+ "█████████████████████████\r\n"
	        			+ "█─▄─▄─█▄─▄█▄─▀█▀─▄█▄─▄▄─█\r\n"
	        			+ "███─████─███─█▄█─███─▄█▀█\r\n"
	        			+ "▀▀▄▄▄▀▀▄▄▄▀▄▄▄▀▄▄▄▀▄▄▄▄▄▀");
	            Game.Level2();

	        	
	        }
	        else if (playerValue > dealerValue) {
	        	int P = 0;
    			for (int i = 0; i < playerCards.length; i++) {
    				if (playerCards[i] > 0) {
    					P = playerCards[i];
    					System.out.println("Your cards: " + P);}}
         System.out.println("Your final hand value is " + getHandValueP(playerCards, PlayerCardcount));
	            System.out.println("\r\n"
	            		+ "█████████████████████████████████████████████\r\n"
	            		+ "█▄─█─▄█─▄▄─█▄─██─▄███▄─█▀▀▀█─▄█▄─▄█▄─▀█▄─▄█░█\r\n"
	            		+ "██▄─▄██─██─██─██─█████─█─█─█─███─███─█▄▀─██▄█\r\n"
	            		+ "▀▀▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▀▀▀▀▀▄▄▄▀▄▄▄▀▀▄▄▄▀▄▄▄▀▀▄▄▀▄▀");
	            Game.Level2();

	            
	            
	        } else if (playerValue < dealerValue) {
	        	int P = 0;
    			for (int i = 0; i < playerCards.length; i++) {
    				if (playerCards[i] > 0) {
    					P = playerCards[i];
    					System.out.println("Your cards: " + P);}}
         System.out.println("Your final hand value is " + getHandValueP(playerCards, PlayerCardcount));
	            System.out.println("\r\n"
	            		+ "████████████████████████████████████████████████\r\n"
	            		+ "█▄─█─▄█─▄▄─█▄─██─▄███▄─▄███─▄▄─█─▄▄▄▄█▄─▄▄─█████\r\n"
	            		+ "██▄─▄██─██─██─██─█████─██▀█─██─█▄▄▄▄─██─▄█▀█░░██\r\n"
	            		+ "▀▀▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▀▀▀▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▀▀");
	            
	            Game.Level2();
	            
	            
	        } else {
	            System.out.println("\r\n"
	            		+ "█████████████████████████████████████████████████\r\n"
	            		+ "█▄─▄█─▄─▄─█░█─▄▄▄▄████▀▄─████─▄─▄─█▄─▄█▄─▄▄─█████\r\n"
	            		+ "██─████─███▄█▄▄▄▄─████─▀─██████─████─███─▄█▀█░░██\r\n"
	            		+ "▀▄▄▄▀▀▄▄▄▀▀▀▀▄▄▄▄▄▀▀▀▄▄▀▄▄▀▀▀▀▄▄▄▀▀▄▄▄▀▄▄▄▄▄▀▄▄▀▀");
	            
	            Game.Level2();
	        }
	        
	       
	    }

	 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rules(); //rules
		
		//assinging parameters
		boolean nextLevel = true;
		while(nextLevel) {
		int[] playerCards = new int[11]; 
	    int[] dealerCards = new int[11];
	    int PlayerCardcount = 0;
	    int DealerCardcount = 0;
	    initialDeal(playerCards, dealerCards, PlayerCardcount, DealerCardcount);
	    determineWinner(playerCards, dealerCards, PlayerCardcount, DealerCardcount);}
	    Level2();
	}

}
