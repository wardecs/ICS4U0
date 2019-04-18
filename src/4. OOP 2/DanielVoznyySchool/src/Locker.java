import java.util.Arrays;

public class Locker {
    int number;
    Student owner;
    private Jacket studentJacket;
    private Book[] books;

    public Locker(Student me) {
        this.owner = me;
        this.number = (int) (Math.random() * 1000);
        this.books = new Book[4];
        this.studentJacket = me.myJacket;
    }

    public Jacket getStudentJacket() {
        return studentJacket;
    }

    public void putStudentJacket(Jacket studentJacket) {
        this.studentJacket = studentJacket;
    }

    @Override
    public String toString() {
        return "Locker " + number + " belongs to " + owner;
    }
}
