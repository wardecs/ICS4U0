/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card heartsAce = new Card("Ace", "Hearts", 1);
		Card heartsTwo = new Card("Two", "Hearts", 2);
		Card heartsThree = new Card("Three", "Hearts", 3);

		if(heartsAce.matches(heartsTwo))
			System.out.println(heartsAce.toString() + " matches " + heartsTwo);
		else
			System.out.println(heartsAce.toString() + " does not match " + heartsTwo);

		int points = 0;
		points += heartsAce.pointValue() + heartsTwo.pointValue() + heartsThree.pointValue();
		System.out.println("Total points: " + points);
	}
}
