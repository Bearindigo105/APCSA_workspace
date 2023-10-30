/*
 * @author Subhash Muthu
 * 
 * 
 */
public class Deck {
	private Card[] cardArray;
	int nextToDeal = 0;

	private static final char[] suitArray = { 'H', 'C', 'D', 'S' };
	private static final String[] rankValueArray = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	public Deck() {
		cardArray = new Card[52];
		for (int i = 0; i < rankValueArray.length; i++) {
			for (int j = 0; j < suitArray.length; j++) {
				cardArray[i + (j * 13)] = new Card(suitArray[j], rankValueArray[i], i + 2);

			}
		}
	}

	public void shuffle() {
		Card[] shuffledArray = new Card[cardArray.length];

		for (int i = 0; i < shuffledArray.length; i++) {
			int cardIndex = (int) (Math.random() * 52);
			Card card = cardArray[cardIndex];
			Card card2 = cardArray[i];

			cardArray[cardIndex] = card2;
			cardArray[i] = card;
		}
		nextToDeal = 0;
	}

	public Card deal() {
		if (nextToDeal <= cardArray.length) {
			Card cardToDeal = cardArray[nextToDeal];
			nextToDeal++;
			return cardToDeal;
		} else {
			return null;
		}
	}

	public static char[] getSuitArray() {
		return suitArray;
	}

	public static String[] getRankValueArray() {
		return rankValueArray;
	}

	public Card[] getCards() {
		return cardArray;
	}
}