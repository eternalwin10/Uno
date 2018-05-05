import java.util.*;

public class GameSetup {
	
	int players = 0;
	LinkedList<String> player1 = new LinkedList<String>();
	LinkedList<String> player2 = new LinkedList<String>();
	LinkedList<String> player3 = new LinkedList<String>();
	LinkedList<String> player4 = new LinkedList<String>();
	Stack<String> deck = new Stack<String>();
	Queue<String> nextPlayerHand = new LinkedList<String>();
	
	public void getPlayers(int players) {
		
		if (players == 2) {
			
			for (int i = 0; i < 6; i++) {
				
				player1.add(drawCard(deck));
				player2.add(drawCard(deck));
			}
			
			nextPlayerHand.add("player 1");
			nextPlayerHand.add("player 2");
			
		}
		
		else if (players == 3) {
			
			for (int i = 0; i < 6; i++) {
			
				player1.add(drawCard(deck));
				player2.add(drawCard(deck));
				player3.add(drawCard(deck));
			}
			
			nextPlayerHand.add("player 1");
			nextPlayerHand.add("player 2");
			nextPlayerHand.add("player 3");
		
		}
		
		else {
			
			for (int i = 0; i < 6; i++) {
				
				player1.add(drawCard(deck));
				player2.add(drawCard(deck));
				player3.add(drawCard(deck));
				player4.add(drawCard(deck));
			}
			
			nextPlayerHand.add("player 1");
			nextPlayerHand.add("player 2");
			nextPlayerHand.add("player 3");
			nextPlayerHand.add("player 4");
		}
		
	}
	
	public void createDeck(Stack<String>deck) {
		String card = "";
		
		for (int z = 0; z < 4; z++) {
			String color [] = {"R", "B", "G", "Y"};
			for (int i = 0; i < 10; i++) {
				card = color[z] + " " + i;
				deck.push(card);
			}
			for (int i = 1; i < 10; i++) {
				card = color[z] + " " +i;
				deck.push(card);
			}
			for (int i = 0; i < 4; i++) {
				card = "NC Wild";
				deck.push(card);
			}
			for (int i = 0; i < 4; i++) {
				card = "NC Wild 4+";
				deck.push(card);
			}
			for (int i = 0; i < 2; i++) {
				card = color[z] + " Draw 2";
				deck.push(card);
			}
			for (int i = 0; i < 2; i++) {
				card = color[z] + " Reverse";
				deck.push(card);
			}
			for (int i = 0; i < 2; i++) {
				card = color[z] + " Skip";
				deck.push(card);
			}
		}	
	}
	public String drawCard(Stack<String>deck) {
		
		for (int i = 0; i < deck.size(); i++) {
	        
            if (deck.pop() == null) {
            	
                continue;
            }
            
            String temp = deck.pop();
            deck = null;
            return temp;
        }
		return null;
	}
	
	public LinkedList<String> getPlayerHand(String getHand, LinkedList<String>takeHand) {
		
		LinkedList<String> player = new LinkedList<String>(); 
 		
		if (getHand.equals("player 1")) {
			
			for (int k = 0; k < player1.size(); k++) {
				
				takeHand.add(player1.get(k));
			}
			player = player1;
		}
		
		else if (getHand.equals("player 2")) {
			
			for (int k = 0; k < player2.size(); k++) {
				
				takeHand.add(player2.get(k));
			}
			player = player2;
		}
		
		else if (getHand.equals("player 3")) {
		
			for (int k = 0; k < player3.size(); k++) {
				
				takeHand.add(player3.get(k));
			}
			player = player3;
		}
		
		else {
			
			for (int k = 0; k < player4.size(); k++) {
				
				takeHand.add(player4.get(k));
			}
		
			player = player4;
		
		}
		
		return player;
	}
	
	public boolean isWinner(LinkedList<String> player1) {
		
		boolean winner = false;
		int getLength = player1.size();
		
		if (getLength != 1) {
			
			winner = false;
			
		}
		
		else {
			
			winner = true;
		}
		
		return winner;
	}
}
