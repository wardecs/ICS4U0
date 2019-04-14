import java.util.Arrays;

/**
 * The Comparator class will recursively check if a list of Comparables contain a Comparable
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @author Daniel Voznyy
 * @version 15.04.19
 */

public class Comparator {
    /**
     * Runs the program. Creates an array of Comparable objects, specifically Integers, then prints whether that array
     * contains 9
     * @param args passed command line arguments
     */
    public static void main(String[] args) {
        Integer[] digits = {1, 2, 3, 4, 5, 6};
        System.out.println(compare(digits, 9));
    }

    /**
     * Checks if list contains comparator. If the first item of list is equal to comparator, returns true. Then,
     * if the list is only one in length, returns false. If neither condition is met, it return the result of a new call
     * to compere() with a subset of list where the first item has been removed.
     * @param list the list of Comparables
     * @param comparator a Comparable to be compared to
     * @return whether or not list contains comparator
     */
    public static boolean compare(Comparable[] list, Comparable comparator) {
        if(list[0].equals(comparator))
            return true;
        if(list.length == 1)
            return false;
        return compare(Arrays.copyOfRange(list, 1, list.length), comparator);
    }
}