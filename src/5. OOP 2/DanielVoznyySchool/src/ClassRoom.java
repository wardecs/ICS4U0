/**
 * Classroom creates a scenario with a student entering a classroom.
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @author Daniel Voznyy
 * @version 24.04.19
 */
public class ClassRoom {
    String name;
    String teacher;

    /**
     * Constructor for the classroom
     *
     * @param name the name of the class
     * @param teacher the class' teacher
     */
    public ClassRoom(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    /**
     * If the student entering the class doesn't have a locker, they get sent to the office, if they have a jacket,
     * they get sent to their locker to put it back and are not let in, if they have less than a certain number of books,
     * they are not let in.
     *
     * @param student the student entering the classroom
     * @return whether the student was let inside
     */
    Boolean enter(Student student) {
        System.out.println("Student " + student + " came into class " + name + " taught by " + teacher);
        if (student.myLocker == null) {
            student.sendToOffice("Get a locker");
            return false;
        }
        if (student.myJacket != null) {
            student.myLocker.putJacket(student.myJacket); //put jacket back in locker
            return false;
        }
        if (student.books.length < 2) { //TODO are they supposed to pass the number of books needed?
            student.sendToOffice("Class " + name + " requires 2 books");
            return false;
        }
        return true;
    }
}
