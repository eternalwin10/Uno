import java.util.*;

public class Uno {

	public static void main(String[] unoMain) {

		GameSetup gs = new GameSetup();
		CardRules cr = new CardRules();
		Scanner s = new Scanner (System.in);
		String pileCard = "", getNumber = "", winningPlayer = "", takePlayer = "";
		boolean isWinner = false, checkPlayers = false, isValid = false, isEmpty = false, saidUno = false;
		LinkedList<String> takeHand = new LinkedList<String>();
		Stack<String> discardPile = new Stack<String>();
		Queue<String> nextPlayer = new LinkedList<String>();
		//end declaration
		System.out.println("Welcome to Uno!" + "\nHow many Players?");
		//before game begins
		do {
				try {
					
					gs.players = s.nextInt();
					
					if (gs.players < 2 || gs.players > 4) throw new Exception ("Only 2-4 players allowed");
		
					else {
						
						checkPlayers = true;
					}
				}
				
				catch (Exception playersAmount) {
					
					System.out.println(playersAmount.getMessage() + "\nTry Again.");
				
				}
		}
		while (checkPlayers == false);
		
		for (int j = 0; j < gs.players; j++) {
			
			System.out.println("Enter name:");
			//if - else fixes bug
			if (j == 0) {
				
				s.nextLine();
				String addPlayer = s.nextLine();
				nextPlayer.add(addPlayer);
			}
			
			else {
				
				String addPlayer = s.nextLine();
				nextPlayer.add(addPlayer);
		
			}
		}
		//GAME SETUP
		gs.createDeck(gs.deck); //create the deck
		Collections.shuffle(gs.deck); //shuffle the deck
		pileCard = gs.drawCard(gs.deck); //get first card for the game 
		gs.getPlayers(gs.players); //get amount of players for game
		
		//GAME BEGINS
		do { //while no winner exists
	
			for (int i = 0; i < nextPlayer.size(); i++) { //loop turn for players
				
				
				boolean turnOver = false;
				//turn starts
				do {
					//empty out hand for new player every turn
						do {
						
							String who = nextPlayer.peek();
							String tempHoldCard = takeHand.poll();
						
							if (who.equals("1")) {
							
								gs.player1.add(tempHoldCard);
						
							}
						
							else if (who.equals("2")) {
							
								gs.player2.add(tempHoldCard);
							}
						
							else if (who.equals("3")) {
							
								gs.player3.add(tempHoldCard);
							}
						
							else {
							
								gs.player4.add(tempHoldCard);
							}
						} 
						while (takeHand.size() > 0);
					
					discardPile.push(pileCard);
					takePlayer = nextPlayer.poll(); //gets correct player's name
					String getHand = gs.nextPlayerHand.poll(); //gets correct player's hand
					gs.getPlayerHand(getHand, takeHand); //stores correct player's hand 
					
					System.out.println(takePlayer + "'s turn!\nHere is your hand " + takeHand + "\nThe top card is " + pileCard 
										+ "\nChoices: \n\tPass\n\tPlace a Card\n\tSay Uno");
					nextPlayer.add(takePlayer);
					
					String playerMove = s.nextLine();
						
						if (playerMove.equals("pass")) {
							
							String cardDrawn = gs.drawCard(gs.deck);
							takeHand.add(cardDrawn);
							System.out.println("You drew " + cardDrawn);
						}
						
						else if (playerMove.equals("place a card")) {
							
							do {
								
								System.out.println("Which card would you like to put down?");
									playerMove = s.nextLine();
								//checking if they have the card
								for (int k = 0; k < takeHand.size(); k++) {	
									
									String checkCard = takeHand.get(k);
									
									if (checkCard == " ") {
											
										isEmpty = true;
									}
										
									else {
										
										isEmpty = false;
									}
									
									if (isEmpty == true) {
										
										k++;
										getNumber = takeHand.remove(k);
										
									}
										
									if (!playerMove.equals(checkCard)) {
										
										continue;
									}
									
									else if ((!playerMove.equals(checkCard)) && k == 5) {
										
										System.out.println("You don't have that card");
									}
									
									else {
																			
								}//end of checking hand
								
								//check if color is valid
									
								if ((playerMove.substring(0, 1).equals(pileCard.substring(0, 1)) || pileCard.substring(0,2).equals("NC"))) {
												
									isValid = true;
									pileCard = playerMove;
											
										if (takeHand.size() != 1) {
												
											turnOver = true;
											continue;
										}
											
										/**else {
												
												//wait 5 seconds for scanner: "say uno"
											try {
													
												playerMove = s.nextLine().toLowerCase();
												Thread.sleep(5000); //delay 5 secs	
													
												if () throw new Exception("You forgot to say Uno!");
											}
												
											catch (Exception sayUno) {
													
												System.out.println();
											}
										}**/
									}
								
								else if (getNumber != pileCard.substring(2,3)) {
									
									System.out.println("VALID NUMBER");
									pileCard = playerMove;
									turnOver = true;
									isValid = true;
								}
 								
								else  {
										
									System.out.println("You can't put " + playerMove + " on " + pileCard);
								}
							}
						}
						while (isValid == false);
							//turnOver = true;
						}//end of  turn 
					
						else if (playerMove.equals("say uno")) {
							
							if (takeHand.size() != 1) {
								
								System.out.println("You have more than one card!");
							}
							
							else {
								
								saidUno = true;
								System.out.println("You're Safe!");
								//turnOver = true;
							}
						}
						/**else {
							
							System.out.println("That isn't a valid choice, Try Again");
						}**/
						turnOver = true;//testing? prevents 2nd player jump
						gs.nextPlayerHand.addAll(takeHand);
				//end of turn
				}
				while (turnOver == false);
			}
			
			/**if (g.isWinner(player1) == true || g.isWinner(player2) == true || g.isWinner(player3) || g.isWinner(player4)) {
				
				winningPlayer = takePlayer;
				isWinner = true;
			}**/
			//isWinner = true; //testing purposes
		}
		while (isWinner == false); 
		//after game		
		
		System.out.println("GAME OVER\n" + winningPlayer + " Won!");
		
		s.close();
	}

}