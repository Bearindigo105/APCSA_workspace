


public class Project_PokerHand {
    public static void main(String args[]) {
        Card[] cards = {
            new Card('H', "8", 8),
            new Card('J', "8", 8),
            new Card('H', "6", 3),
            new Card('J', "6", 3),
            new Card('C', "6", 3)
        };
        PokerHand pkHand = new PokerHand(cards);
        System.out.println(pkHand.getBestHand());
    }
}
