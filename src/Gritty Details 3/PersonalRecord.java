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
