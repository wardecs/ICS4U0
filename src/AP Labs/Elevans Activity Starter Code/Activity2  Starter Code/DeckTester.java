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
        for (int i = 0; i < 6; i++) {
            System.out.println("Dealt " + p1.deal());
        }
        System.out.println(p1.toString());
    }
}
