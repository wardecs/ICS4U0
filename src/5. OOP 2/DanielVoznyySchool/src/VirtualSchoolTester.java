/**
 * A simulation of the part of a student's day in our school
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @author Daniel Voznyy
 * @version 24.04.19
 */
public class VirtualSchoolTester {
    /**
     * The method that gets run
     *
     * @param args passed arguments
     */
    public static void main(String[] args) {
        Student student = new Student("Daniel");
        ClassRoom classRoom = new ClassRoom("ICS", "Ms. Krasteva");
        System.out.println(student + " has number " + student.number);
        //student takes the book out
        student.myLocker.getABook("ICS");
        System.out.println(student + " now has " + student.books[0] + " on him");

        if (classRoom.enter(student))
            System.out.println(student + " was allowed into class");
        else
            System.out.println(student + " was not allowed into class");

        System.out.println("Daniel came back after putting away his jacket");

        if (classRoom.enter(student))
            System.out.println(student + " was allowed into class");
        else
            System.out.println(student + " was not allowed into class");
    }
}
