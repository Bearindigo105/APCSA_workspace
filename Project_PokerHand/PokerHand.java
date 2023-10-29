
public class PokerHand 
{

	private Card[] hand;
	
	
	
	/*
	 * DONE Create a constructor which takes no arguments and initializes
	 * the hand (our hand always has five cards) to an Ace of hearts, 
	 * King of hearts, Queen of hearts, Jack of hearts, and 10 of hearts.  
	 * This is a royal flush
	 *
	 */
	public PokerHand(){
		hand = new Card[5];
		for (int i = 12; i > 7; i--) {
			System.out.println("D: " + Deck.getRankValueArray()[i]);
			hand[i - 8] = new Card(Deck.getSuitArray()[0], Deck.getRankValueArray()[i], i);
		}
	}

	
	public PokerHand(Card[] cardArray){
		hand = cardArray;
	}
	
	/**
	 * This method sortHandByValue will put your cards in order
	 * from smallest to largest.  It is private and can only be
	 * called in this class.  It may prove useful for you.
	 */
	private void sortHandByValue()
	{
		for(int i = 0; i < hand.length; i++)
		{
			int index = i;
			int minVal = hand[i].getValue();
			for(int j = i+1; j < hand.length; j++)
			{
				if(hand[j].getValue()< minVal)
				{
					index = j;
					minVal = hand[j].getValue();
				}
			}
			Card temp = hand[i];
			hand[i] = hand[index];
			hand[index] = temp;
		}
	}
	
	
	/*
	 * DONE write a method called getBestHand (sorting will help)
	 * this method will take no arguments and will return a String 
	 * identifying the best hand which can be made.  The possible hands 
	 * and return values are as follows. These are in order of precedence
	 * (the ones at the top are the best hands).
	 * return "Royal Flush" if all cards in the hand are the same
	 * 	  suit and the card ranks are A, K, Q, J, 10
	 * return "Straight Flush" if all cards are in the same suit
	 *    and the cards are all in consecutive order by value
	 *    ex.  7H, 8H, 9H, 10H, JH
	 * return "Four of a Kind" if there are four matching cards in hand
	 * 	  ex.  9D, 9H, 9S, 9C, 10D
	 * return "Flush" if all cards are the same suit.  Rank does
	 *    not matter.  Ex.  3S, 7S, 10S, KS, AS
	 * return "Straight" if all cards are in consecutive order
	 *    by value, but not the same suit.  Ex. 4H, 5C, 6H, 7D, 8S
	 * return "Full House" if there 
	 *    are a set of three matching
	 *    ranks and a separate set of two matching ranks.  
	 *    Ex. 4H, 4C, JD, JH, JS
	 * return "Three of a Kind" if there are three cards with the same
	 *    rank.  Ex 5C, 9H, QC, QH, QD
	 * return "Two Pair" if there are two pairs of cards with matching ranks
	 *    Ex.  5H, 5D, 10H, 10C, KC
	 * return "Pair" if there are two matching ranks.  
	 *    Ex. 3D, 5D, 5H, KC, AH
	 * return "High (rank of highest card)" if none of the others apply
	 * 	  Ex.  3D, 6H, 10S, JD, QD would return "High Q"
	 */
	public String getBestHand(){
		
		sortHandByValue();
		String retString = null;
		
		int[] values = new int[hand.length];
		int[] diffValues = new int[hand.length + 1];
		
		for(int i = 0; i < hand.length; i++){
			values[i] = hand[i].getValue();
		}
		
		for (int i = 0; i < hand.length + 1; i++) {
			diffValues[i] = (values[i + 1] - values[i]);	
		}

		System.out.println(intArrIsSame(diffValues));
		System.out.println(diffValues[0]);
		
		
		if(isSameSuit(hand) && largestNumInArr(numbersOfValues(hand)) == 5){
			retString = "Royal Flush";

		}else if(isSameSuit(hand) && intArrIsSame(diffValues) && diffValues[0] == 1){
			retString = "Straight Flush";

		}else if(largestNumInArr(numbersOfValues(hand)) == 4){
			retString = "Four of a Kind";
		
		}else if(isSameSuit(hand)){
			retString = "Flush";

		}else if(intArrIsSame(diffValues) && diffValues[0] == 1){
			retString = "Straight";

		}else if(isFullHouse()){
			retString = "Full House";

		}
		

		return retString;
	}
	
	private int[] numbersOfValues(Card[] cards){
		int[] numbersOfValues = new int[14];

		for (Card card : cards) {
			numbersOfValues[card.getValue()] ++;
		}

		return numbersOfValues;
	}

	private int largestNumInArr(int[] arr){
		int largestNumInArr = 0;
		for (int num : arr) {
			if(num > largestNumInArr){
				largestNumInArr = num;
			}
		}
		return largestNumInArr;
	}

	private int smallestNumInArr(int[] arr){
		int smallestNumInArr = Integer.MAX_VALUE;
		for (int num : arr) {
			if(num < smallestNumInArr){
				smallestNumInArr = num;
			}
		}
		return smallestNumInArr;
	}

	private boolean intArrIsSame(int[] arr){
		int prevNum = arr[0];
		boolean retBool = false;
		for (int num : arr) {
			if(prevNum == num){
				retBool = true;
			}else{
				retBool = false;
			}
		}
		return retBool;
	}
	
	private boolean isFullHouse(){
		return largestNumInArr(numbersOfValues(hand)) == 3 && smallestNumInArr(numbersOfValues(hand)) == 2;
	}

	private boolean isSameSuit(Card[] arr){
		char prevSuit = arr[0].getSuit();
		boolean retBool = false;
		for (Card card : arr) {
			if(card.getSuit() == prevSuit){
				retBool = true;
			}else{
				retBool = false;
			}
		}
		return retBool;
	}
	/*
	 * DONE write a toString method which returns a string containing
	 * the rank and suit of every card in the hand, separated by a comma
	 * Ex.  3D, 4D, 4D, 8S, KH
	 */
	@Override
	public String toString(){
		String retString = null;
		for (Card card : hand) {
			retString += String.format("%c%s, ", card.getRank(), card.getSuit());
		}	
		return retString;
	}


	
	
	/*
	 * DONE Write a method called discard.  The goal of this method is 
	 * to choose cards to discard and replace with new cards.  The 
	 * method should take two arguments, 
	 * the first will be an int array which will store the indexes of 
	 * hand which are to be replaced, and the second is a Card array 
	 * which will contain the new cards to be placed into hand.
	 * Ex.  hand contains 4H,4D,4C,JS,KC  
	 * 		given int[] arr = {3,4};
	 * 		and Card[] cards = {4S,AD} //using shorthand to demonstrate
	 * 		after discard(arr,cards);
	 * 		hand would now contain 4H,4D,4C,4S,AD
	 * 
	 */
	public void discard(int[] indexesToReplace, Card[] replaceCards){
		for (int i = 0; i < indexesToReplace.length; i++) {
			hand[indexesToReplace[i]] = replaceCards[i];
		}
	}
}
