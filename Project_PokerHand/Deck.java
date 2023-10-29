public class Deck 
{
	private Card[] cardArray;
	int nextToDeal = 0;
	
	private static final char[] suitArray = {'H', 'C', 'D', 'S'};
	private static final String[] rankValueArray = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	public Deck(){
		cardArray = new Card[52];
		for (int i = 0; i < rankValueArray.length; i++) {
			for (int j = 0; j < suitArray.length; j++) {
				cardArray[i] = new Card(suitArray[j], rankValueArray[i], i + 2);
			}
		}
	}
	
	public void shuffle(){
		Card[] shuffledArray = new Card[cardArray.length];
		for (int i = 0; i < shuffledArray.length; i++) {
			Card nextToShuffle;
			do{
				nextToShuffle = cardArray[(int)Math.random() * 51];
			}while(!cardArrayContains(shuffledArray, nextToShuffle));
			shuffledArray[i] = nextToShuffle;
		}
	}

	public boolean cardArrayContains(Card[] cardArray, Card cardToFind){
		for (Card card : cardArray) {
			if(cardToFind == card){
				return true;
			}			
		}
		return false;
	}

	public Card deal(){
		if(nextToDeal == cardArray.length){
			nextToDeal ++;						// this needs to be in this order so that it executes properly.
			return cardArray[nextToDeal - 1];
		}
		return null;
	}
	
	public static char[] getSuitArray() {
		return suitArray;
	}

	public static String[] getRankValueArray() {
		return rankValueArray;
	}

	public Card[] getCards(){
		return cardArray;
	}
}