/**
 * @author Daniel Voznyy
 * Ms. Krasteva
 * March 18, 2019
 * An interface for personal info regarding birthdays
 */

import java.util.Calendar;

public interface PersonalInfo {

    Calendar getFileCreationDate();

    int getCurrentAge(int birthYear);
}
