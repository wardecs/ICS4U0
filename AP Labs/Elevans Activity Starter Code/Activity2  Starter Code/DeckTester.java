/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        Deck p1 = new Deck(new String[]{"Ace", "Two"}, new String[]{"Diamonds", "Clubs", "Spades", "Hearts"}, new int[]{1, 2});
        Deck p2 = new Deck(new String[]{"King", "Queen"}, new String[]{"Diamonds"}, new int[]{11, 11});
        Deck p3 = new Deck(new String[]{"Ten"}, new String[]{"Diamonds", "Clubs", "Spades", "Hearts"}, new int[]{10});
        for (int i = 0; i < 6; i++)
            System.out.println("Dealt " + p1.deal());
        System.out.println("\nContents of P1's deck now:\n" + p1.toString());

        while(!p2.isEmpty())
            p2.deal();
        System.out.println("Dealt all cards for P2:\n" + p2.toString());

        System.out.println("P3 has " + p3.size() + " cards");
    }


}
