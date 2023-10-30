/*
 * @author Subhash Muthu
 */


public class PokerHand {

	private Card[] hand;

	public PokerHand() {
		hand = new Card[5];
		
		for (int i = 12; i > 7; i--) {
			hand[12 - i] = new Card('H', Deck.getRankValueArray()[i], i - 2);
		}
	}

	public PokerHand(Card[] cardArray) {
		hand = cardArray;
	}

	private void sortHandByValue() {
		for (int i = 0; i < hand.length; i++) {
			int index = i;
			int minVal = hand[i].getValue();
			for (int j = i + 1; j < hand.length; j++) {
				if (hand[j].getValue() < minVal) {
					index = j;
					minVal = hand[j].getValue();
				}
			}
			Card temp = hand[i];
			hand[i] = hand[index];
			hand[index] = temp;
		}
	}

	public String getBestHand() {
		sortHandByValue();

		if (isRoyalFlush()) {
			return "Royal Flush";

		} else if (isStraight() && isFlush()) {
			return "Straight Flush";

		} else if (isOfKind(4)) {
			return "Four of a Kind";

		} else if (isFlush()) {
			return "Flush";

		} else if (isStraight()) {
			sortHandByValue();
			return "Straight";

		} else if (isOfKind(3) && isOfKind(2)) {
			sortHandByValue();
			return "Full House";

		} else if (isOfKind(3)) {
			return "Three of a Kind";

		} else if (isTwoPair()) {
			return "Two Pair";

		} else if (isOfKind(2)) {
			return "Pair";

		} else {
			return "High " + highestRank();

		}
	}

	private boolean isRoyalFlush() {
		boolean royalBool = hand[0].getValue() > 9;

		return isFlush() && royalBool;
	}

	private boolean isOfKind(int kind) {

		for (int num : numsOfValues()) {
			if (num == kind) {
				return true;
			}
		}

		return false;
	}

	private boolean isTwoPair() {

		int numOfPairs = 0;

		for (int num : numsOfValues()) {
			if (num == 2) {
				numOfPairs++;
			}
		}

		if (numOfPairs == 2) {
			return true;
		}

		return false;
	}

	private int[] numsOfValues() {
		int[] retNumsOfValues = new int[15];

		for (Card card : hand) {
			retNumsOfValues[card.getValue()]++;
		}

		return retNumsOfValues;
	}

	private boolean isStraight() {

		for (int i = 0; i < hand.length; i++) {
			if (!(hand[i].getValue() == (hand[0].getValue() + i) || hand[i].getValue() == (hand[0].getValue() - i))) {
				return false;
			}
		}

		return true;
	}

	private boolean isFlush() {

		for (Card card : hand) {
			if (!(card.getSuit() == hand[0].getSuit())) {
				return false;
			}
		}

		return true;
	}

	private String highestRank() {
		int highestValue = 0;
		String highestRank = "";

		for (Card card : hand) {
			if (card.getValue() > highestValue) {
				highestValue = card.getValue();
				highestRank = card.getRank();
			}
		}

		return highestRank;
	}

	public void discard(int[] indexesToReplace, Card[] replaceCards) {
		for (int i = 0; i < indexesToReplace.length; i++) {
			hand[indexesToReplace[i]] = replaceCards[i];
		}
	}

	public String toString() {
		String retString = "";
		for (Card card : hand) {
			retString += card.getRank() + card.getSuit() + ", ";
		}
		retString.trim();
		return retString.substring(0, retString.length() - 2);
	}

}
