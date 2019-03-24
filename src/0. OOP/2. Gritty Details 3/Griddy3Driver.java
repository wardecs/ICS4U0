import java.util.Calendar;

public class Griddy3Driver {
    public static void main(String[] args) {
        PersonalRecord p = new PersonalRecord(Calendar.getInstance(), 15);
        System.out.println(p.getCurrentAge(2003));
    }
} //Driver class
