import java.util.Arrays;

public class Comparator {
    public static void main(String[] args) {
        Integer[] digits = {1, 2, 3, 4, 5, 6};
        System.out.println(compare(digits, 9));
    }

    public static boolean compare(Comparable[] list, Comparable comparator) {
        if(list.length <= 1)
            return false;
        if(list[0].equals(comparator))
            return true;
        return compare(Arrays.copyOfRange(list, 1, list.length), comparator);
    }
}