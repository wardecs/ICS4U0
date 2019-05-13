### Activity 2

1. Explain in your own words the relationship between a deck and a card.

A deck is a set of cards.

2. Consider the deck initialized with the statements below. How many cards does the deck contain?

```Java
    String[] ranks = {"jack", "queen", "king"};
    String[] suits = {"blue", "red"};
    int[] pointValues = {11, 12, 13};
    Deck d = new Deck(ranks, suits, pointValues);
```

`Deck d` contains `ranks.length * suits.length` = `6` decks, since for each suit, each rank will be created. Point values to not affect this process.

3. The game of Twenty-One is played with a deck of 52 cards. Ranks run from ace (highest) down to 2 (lowest). Suits are spades, hearts, diamonds, and clubs as in many other games. A face card has point value 10; an ace has point value 11; point values for 2, …, 10 are 2, …, 10, respectively. Specify the contents of the `ranks` , `suits` , and `pointValues` arrays so that the statement `Deck d = new Deck(ranks, suits, pointValues);` initializes a deck for a Twenty-One game.

```Java
String[] ranks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
String[] suits = {"spades", "hearts", "diamonds", "clubs"};
int[] pointValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
```

4. Does the order of elements of the `ranks` , `suits` , and `pointValues` arrays matter?

The order of elements of the `ranks` and `pointValues` arrays matter, since they assign points relative to each other (i.e. element at index `i` of `ranks` will get a point value of element at index `i` of `pointValues`). The order of `suits` does not matter unless the deck must have suits in a specific order.

### Activity 4

1. Write a static method named flip that simulates a flip of a weighted coin by returning either
"heads" or "tails" each time it is called. The coin is twice as likely to turn up heads as tails.
Thus, flip should return "heads" about twice as often as it returns "tails."

```Java
public static String flip() {
	return Math.random() * 3 < 2 ? "heads" : "tails";
}
```

2. Write a static method named `arePermutations` that, given two `int` arrays of the same length but with no duplicate elements, returns true if one array is a permutation of the other (i.e., the arrays differ only in how their contents are arranged). Otherwise, it should return false.

```java
public static boolean arePermutations(int[] as, int[] bs) {
    //label for outer for loop
    fora:
    for (int a : as) { //for each item in as
        for (int b : bs) //compare to each item in b
            if (a == b)
                continue fora; //if they match, continue to next item in as
        return false; //if we've checked all items and none matched, arrays are not permutations
    }
    return true;
}
```

3. Suppose that the initial contents of the values array in Shuffler.java are {1, 2, 3, 4}. For what sequence of random integers would the efficient selection shuffle change values to contain {4, 3, 2, 1}?

`0, 1, 1`. 

`0` 4 and 1 swap `1, 2, 3, 4 = 4, 2, 3, 1`;

`1` 2 and 3 swap `4, 2, 3, 1 = 4, 3, 2, 1`;

The last `1` is needed for the 3 to switch with itself, since the program doesn't stop itself until it reaches the beginning of the array.

### Activity 5:

1. Constructor or Method (write method name), then write a Possible Code Error

Buggy1: `isEmpty()` was checking `size < 0` instead of `size == 0`
Buggy2: In constructor, the for loop starts with `var4 = 1`, when it should be `var4 = 0`. It doesn't necessarily generate a runtime error, but doesn't run as intended.
Buggy3: in `shuffle()` for loop, the end condition is `var1 < 0`, instead of `var1 > 0`, causing it to stop right away.
Buggy4: in `deal()` `--this.size` was occuring even if the deck was empty

Buggy5: `isEmpty` once again checks for `size < 0`

### Activity 6:

1. List all possible plays for the board 5♠ 4♥ 2♦ 6♣ A♠ J♥ K♦ 5♣ 2♠

`5♠ + 6♣ = 11`. `5♣ + 6♣ = 11`. `A♠ & J♥ & K♦` is a triplet.

2. If the deck is empty and the board has three cards left, must they be J, Q, and K? Why or why not?

There are 4 Jacks, Queens and Kings, one for each suit, therefore a total of 4 triplet plays can be made. 4 triplet plays * 3 cards = 12 cards

52 total cards - 12 = 40. These 40 cards can only be removed in pairs of two, meaning the board would have to end with two cards.

Therefore, if three cards are left on the board, they must be one of the triplet plays.

3. Does the game involve any strategy? That is, when more than one play is possible, does it matter
   which one is chosen? Briefly explain your answer.

The game involves no strategy since whenever the player has a choice between more than one card match, the order doesn't affect anything.

### Activity 7:

1. What items would be necessary if you were playing a game of Elevens at your desk (not on the
    computer)? List the private instance variables needed for the `ElevensBoard` class.

You would need a deck of cards, as well as a board. The instance variables needed would be of `Deck` for the deck and `Card[]` for the board.

2. Write an algorithm that describes the actions necessary to play the Elevens game.

```
Shuffle the deck
Deal 9 cards
If a move is possible
	If two cards add to 11
		Select pair and replace
	Else if a triplet exists
		Select the three cards and replace
Else if there are no more cards on the board
	You win
Otherwise
	You lose
```

3. Now examine the partially implemented ElevensBoard.java file found in the Activity7
   Starter Code directory. Does the `ElevensBoard` class contain all the state and behavior
   necessary to play the game?

The only missing functionality is for actually selecting the cards

4. ElevensBoard.java contains three helper methods. These helper methods are private
   because they are only called from the `ElevensBoard` class.
     a. Where is the `dealMyCards` method called in `ElevensBoard`?

   `dealMyCards` is called in the constructor and `newGame` method.

     b. Which public methods should call the `containsPairSum11` and `containsJQK`
     methods?

   `isLegal` and `anotherPlayIsPossible` should call these methods.

     c. It’s important to understand how the `cardIndexes` method works, and how the list that it
     returns is used. Suppose that cards contains the elements shown below. Trace the execution
     of the `cardIndexes` method to determine what list will be returned. Complete the diagram
     below by filling in the elements of the returned list, and by showing how those values index
     cards. Note that the returned list may have less than 9 elements.

   | 0    | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    |
   | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
   | J♥   | 6♣   | null | 2♠   | null | null | A♠   | 4♥   | null |
   | 0    | 1    | 3    | 6    | 7    |      |      |      |      |

   d. Complete the following `printCards` method to print all of the elements of cards that are indexed by `cIndexes`.

 ```Java
public static printCards(ElevensBoard board) {
    List<Integer> cIndexes = board.cardIndexes();
    
    for(Integer cIndex: cIndexes)
        Sustem.out.println(board.cardAt(cIndex.intValue()));
}
 ```

  e. Which one of the methods that you identified in question 4b above needs to call the
  `cardIndexes` method before calling the `containsPairSum11` and `containsJQK`
  methods? Why?

`anotherPlayIsPossible` needs to do this to get the indices of all the cards on the board to check for cards that add to 11 or are a triplet.

### Activity 8:

1. Discuss the similarities and differences between `Elevens`, `Thirteens`, and `Tens`.

| Similarities                | Differences                                                  |
| --------------------------- | ------------------------------------------------------------ |
| All singleplayer            | Number of cards on board                                     |
| All card games with a board | Different groups of cards can be selected together to be removed |
| Cards can be removed        | The sums pairs should add up to, to be removed               |

2. As discussed previously, all of the instance variables are declared in the Board class. But it is the
   `ElevensBoard` class that “knows” the board size, and the ranks, suits, and point values of the
   cards in the deck. How do the `Board` instance variables get initialized with the `ElevensBoard` values? What is the exact mechanism?

```java
super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
```

3. Now examine the files Board.java, and ElevensBoard.java, found in the Activity8
   Starter Code directory. Identify the abstract methods in Board.java. See how these
   methods are implemented in ElevensBoard. Do they cover all the differences between Elevens,
   Thirteens, and Tens as discussed in question 1? Why or why not?

The abstract methods are `isLegal` and `anotherPlayIsPossible`. They do not cover the groups of cards that can be selected together or the sums cards should add up to.

### Activity 9:

1. The size of the board is one of the differences between Elevens and Thirteens. Why is size not an abstract method?

Because the size is already defined in the array of cards.

2. Why are there no abstract methods dealing with the selection of the cards to be removed or replaced in the array cards?

Because all the games will be selecting and removing the cards in almost identical ways.

1. Another way to create “IS-A” relationships is by implementing interfaces. Suppose that instead of creating an abstract `Board` class, we created the following `Board` interface, and had
  `ElevensBoard` implement it. Would this new scheme allow the Elevens GUI to call `isLegal`
  and `anotherPlayIsPossible` polymorphically? Would this alternate design work as well as
  the abstract Board class design? Why or why not?

```Java
public interface Board {
    boolean isLegal(List<Integer> selectedCards);
    boolean anotherPlayIsPossible();
}
```

This design would not work as well because we cannot define existing code for things like selecting and removing cards, and each subclass would need to recreate identical methods for it.

### Activity 11:

1. Set the I_AM_DEBUGGING flags to false and GAMES_TO_PLAY to 10. Run the ElevensSimulation program a few times and record the percentage of games won for each run.
What is the range of win percentages that you saw? Were the percentages fairly consistent, or did they vary quite a bit?

The percentages ranged between 0 and 30. They varied so much due to the small amount of games being played

2. Increase the number of games to play to 100. Are the win percentages more consistent from run to run?

The percentages are now more consistent, settling in at ~10%

3. Experiment with simulating different numbers of games. How many games do you need to play in order to get consistent results from run to run?

1000 games seems to be getting to a fairly consistent point.