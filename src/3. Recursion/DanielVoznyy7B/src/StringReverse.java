import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringReverse {
    /*public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        readString(strings);

        reverse(strings);
    }

    public static void readString(ArrayList<String> strings){
        try {
            String line;
            if(!(line = new BufferedReader(new InputStreamReader(System.in)).readLine()).equals(".")) {
                strings.add(line);
                readString(strings);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> reverse(List<String> strings) {
        System.out.println(strings.get(0));
        if (strings.size() <= 1)
            return strings;
        return reverse(strings.subList(1, strings.size())).add(strings.get(0));
    }*/
}