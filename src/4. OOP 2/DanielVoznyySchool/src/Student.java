import java.util.Arrays;

public class Student {
    String number;
    String name;
    Locker myLocker;
    Jacket myJacket;
    Book[] books;

    public Student(String name) {
        this.name = name;
        this.number = Double.toString(Math.random() * 3000000);
        this.myLocker = new Locker(this);

    }

    public void sendToOffice(String reason) {

    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", myLocker=" + myLocker +
                ", myJacket=" + myJacket +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
