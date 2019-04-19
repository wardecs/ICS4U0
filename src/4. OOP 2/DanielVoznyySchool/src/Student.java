public class Student {
    String name;
    String number;
    Locker myLocker;
    Jacket myJacket;
    Book[] books;

    public Student(String name) {
        this.name = name;
        this.number = Double.toString(Math.random() * 3000000);
        this.myLocker = new Locker(this);
        this.myJacket = new Jacket(this);
        this.books = new Book[4];
    }

    public void sendToOffice(String reason) {
        System.out.println(toString() + " got sent to the office with the reason: " + reason);
    }

    @Override
    public String toString() {
        return name;
    }
}
