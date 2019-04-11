package src;

public class RevDigits {
    public static void main(String[] args) {
        int digits = 123456789;
//        System.out.println("The digits reversed are " + revDigits(digits));
        //get first digit
//        System.out.println((digits / (int) Math.pow(10, (int)(Math.log10(digits)))));
//        System.out.println((digits - (digits / (int) Math.pow(10, (int)(Math.log10(digits)))) * (int) Math.pow(10, (int)(Math.log10(digits)))) * 10 + (digits / (int) Math.pow(10, (int)(Math.log10(digits)))));
//        System.out.println(((int) Math.pow(10, (int)(Math.log10(digits))) * (digits / (int) Math.pow(10, (int)(Math.log10(digits))))));
        System.out.println(revDigits(digits));
    }

    public static int revDigits(int digits) {
        if ((int)(Math.log10(digits)+1) <= 1)
            return digits;
        return revDigits(digits - (digits / (int) Math.pow(10, (int)(Math.log10(digits)))) * (int) Math.pow(10, (int)(Math.log10(digits)))) * 10 + (digits / (int) Math.pow(10, (int)(Math.log10(digits))));
    }
}