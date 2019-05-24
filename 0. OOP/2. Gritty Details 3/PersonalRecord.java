/**
 * @author Daniel Voznyy
 * Ms. Krasteva
 * March 18, 2019
 * A subclass of PersonalInfo with working methods
 */

import java.util.Calendar;

public class PersonalRecord implements PersonalInfo {
    private Calendar creationDate;
    private int currentAge;

    PersonalRecord(Calendar creationDate, int currentAge) {
        this.creationDate = creationDate;
        this.currentAge = currentAge;
    }

    public Calendar getFileCreationDate() {
        return creationDate;
    }

    public int getCurrentAge(int birthYear) {
        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }
}
