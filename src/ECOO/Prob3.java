import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob3 {
    public static void main(String[] args) {
        try {
            BufferedReader b = new BufferedReader(new FileReader("src/ECOO/DATA31.txt"));
            System.out.println("YAY");
            int cases, x, y, z;
            ArrayList<String> lines = new ArrayList<>();

            String l;
            try {
                while (!(l = b.readLine()).isEmpty()) {
                    lines.add(l);
                }
            }catch(NullPointerException e){}


            String[] vars = lines.get(0).split(" ");
            cases = Integer.parseInt(vars[0]);
            x = Integer.parseInt(vars[1]);
            y = Integer.parseInt(vars[2]);
            z = Integer.parseInt(vars[3]);

            System.out.println(lines.toString());


            System.out.println(x);

            for (int casenum = 0; casenum < lines.size() - 1;) {
                String failed = "FAIL: ";
                for (int i = 0; i < cases; i++) {
                    String in = lines.get(casenum + i + 1);
                    String out = lines.get(casenum + i + cases + 2);
                    List<Integer> inAr = new ArrayList<>();
                    for (String s : Arrays.asList(in.split(""))) {
                        inAr.add(Integer.parseInt(s));
                    }

                    List<Integer> outAr = new ArrayList<>();
                    for (int j = 0; j < inAr.size(); j++) {
                        int num = inAr.get(j);
                        if (num % 2 == 0) {
                            outAr.add(num + x);
                        } else {
                            if (num - y < 0)
                                outAr.add(z);
                            else
                                outAr.add(num - y);
                        }
                    }

                    String outFromIn = "";
                    for (int s : outAr) {
                        outFromIn += s;
                    }


                    if (!outFromIn.equals(out))
                        failed += i + 1 + ",";
                }
                System.out.println();
                if(failed.equals("FAIL: ")) //we know its not failed
                    System.out.println("MATCH");
                else
                    System.out.println(failed.substring(0, failed.length() - 1));
                casenum+= cases + 1;
            }
        } catch(IOException e){
            System.out.println("OH NO!");
        }
    }
}
