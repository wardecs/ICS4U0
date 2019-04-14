import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The StringReverse class allows the user to input multiple strings, then after a "." is inputted, the program will
 * output a the user's inputs in reverse order.
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @author Daniel Voznyy
 * @version 15.04.19
 */

public class StringReverse {
    /**
     * Runs the program. Reads user string inputs until the user inputs ".".
     * Separates inputs with new lines, then prints the output of revWords().
     * @param args passed command line arguments
     */
    public static void main(String[] args) {
        String words = "";
        try {
            String word;
            while (!(word = new BufferedReader(new InputStreamReader(System.in)).readLine()).equals(".")) { //keep going until the input is "."
                words += word + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        words += ".\n"; //dot stops the while loop so we need to add it manually
        System.out.println(revWords(words));
    }

    /**
     * Takes a string `input`, and reverses its order by new lines.
     * Takes everything before the first new line character and moves it to the end of the string, then recursively
     * does the same with whatever is left over after the new line character. Requires for the input to end in a new
     * line.
     * <p>e.x. (where \n is shown as a space character, " ")
     * <p>a b . 
     * <p>=revWords(b . ) + a
     * <p>=(revWords(. ) + b ) + a
     * <p>=(.  + b ) + a
     * <p>=. b a
     * @param input the original string
     * @return the string in reversed order
     */
    public static String revWords(String input) {
        if (input.indexOf("\n") == input.length() - 1)
            return input;
        return revWords(input.substring(input.indexOf("\n") + 1)) + input.substring(0, input.indexOf("\n") + 1);
    }
}