package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {
    public static void main(String[] args) {
        String word = "music";
        System.out.println("The word reversed is " + reverse(word));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {
            while (!(line = br.readLine()).equals(".")) {

            }
        } catch (IOException e) {
        }
    }

    public static String reverse(String word) {
        System.out.println(word);
        if (word.length() <= 1)
            return word;
        return reverse(word.substring(1)) + (word.charAt(0));
    }
}