/**
 * The RevDigits class will reverse an integer number's digits
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @author Daniel Voznyy
 * @version 15.04.19
 */
public class RevDigits {
    /**
     * Runs the program. Contains an integer which then gets passed into revDigits, whose output will be printed
     * @param args passed command line arguments
     */
    public static void main(String[] args) {
        int digits = 123456789;
        System.out.println(revDigits(digits));
    }

    /**
     * Reverses the order of digits of an integer.
     * As long as the integer has more than one digit, it finds the digits other than the first digit, calls the
     * revDigits method on them, then multiplies its result by 10 and adds the first digit of the input to its end
     * <p>e.x.
     * <p>123
     * <p>= revDigits(23) * 10 + 1
     * <p>= (revDigits(3) * 10 + 2) * 10 + 1
     * <p>= ((3) * 10 + 2) * 10 + 1
     * <p>= (32) * 10 + 1
     * <p>= 320 + 1
     * <p>= 321
     * @param digits inputted integer
     * @return integer with its digits in reverse order
     */
    public static int revDigits(int digits) {
        if (digits < 10) //if one digit is left
            return digits;
        return revDigits(digits - (digits / (int) Math.pow(10, (int) (Math.log10(digits)))) * (int) Math.pow(10, (int) (Math.log10(digits)))) * 10 + (digits / (int) Math.pow(10, (int) (Math.log10(digits))));
    }
}