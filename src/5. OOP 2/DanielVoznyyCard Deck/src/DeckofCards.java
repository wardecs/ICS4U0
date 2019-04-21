public class DeckofCards {

    private Card myDeck[];

    private int myCardNum = 0;


    public DeckofCards() {
        String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
        myDeck = new Card[52];

        for (int n = 0; n < 52; n++) {
            myDeck[n] = new Card(faces[n % 13], suits[n / 13]);
        }
    }
// end constructor

    // method to deal cards


    public Card deal() {
        if (myCardNum < 52)
            return myDeck[myCardNum++];
        else
            return null;
    }
// end deal() method


    public void shuffle() {
        for (int i = 0; i < myDeck.length; i++) { //for every card in the deck, in order
            Card temp = myDeck[i]; //get one card
            int otherCardI = (int) (Math.random() * 13); //get another card at a random position
            //swap places
            myDeck[i] = myDeck[otherCardI];
            myDeck[otherCardI] = temp;
        }
        myCardNum = 0; //now that the cards are shuffled, we should start dealing them from the beginning
    }
// end shuffle() method

    @Override
    public String toString() {
        String deck = "";
        for (int n = 0; n < 52; n++) { //go through each card
            Card card = myDeck[n];
            deck += card; //add the card name to the deck String
            //One tab = 4 regular characters. We assume no card's name is longer than 5 tabs, so we print out 5 tabs - amount of tabs a word takes up (the remainder is accounted for by the tab character).
            for (int i = 0; i < 5 - card.toString().length() / 4; i++)
                deck += "\t";
        }
        return deck;
    }
}
// close class