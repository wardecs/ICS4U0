/**
 * Jacket has a Student owner
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @author Daniel Voznyy
 * @version 24.04.19
 */
public class Jacket {
    Student owner;

    /**
     * Jacket constructor
     *
     * @param me the student who owns the jacket
     */
    public Jacket(Student me) {
        this.owner = me;
    }

    @Override
    public String toString() {
        return owner + "'s jacket";
    }
}
