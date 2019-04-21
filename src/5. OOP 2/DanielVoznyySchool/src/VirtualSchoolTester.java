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
    public static void main(String[] args) {
        Student student = new Student("Daniel");
        ClassRoom classRoom = new ClassRoom("ICS", "Ms. Krasteva");

        //make a new book
        Book apTextbook = new Book();
        apTextbook.setCourse("ICS");
        apTextbook.setTitle("AP ICS textbook");

        //put it in the locker
        student.myLocker.putABook(apTextbook);

        //student takes the book out
        student.books[0] = student.myLocker.getABook("ICS");
        System.out.println(student + " now has " + student.books[0] + " on him");

        //put the jacket student is wearing into the locker
        student.myLocker.putJacket(student.myJacket);

        System.out.println(student + "'s locker has jacket: " + student.myLocker.checkJacket());
        System.out.println(student + " has jacket " + student.myJacket);

        if (classRoom.enter(student))
            System.out.println(student + " was allowed into class");
        else
            System.out.println(student + " was not allowed into class");

        System.out.println(student + " takes jacket from locker");
        student.myJacket = student.myLocker.getJacket();

        if (classRoom.enter(student))
            System.out.println(student + " was allowed into class");
        else
            System.out.println(student + " was not allowed into class");
    }
}
