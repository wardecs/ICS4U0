public class Locker {
    int number;
    Student owner;
    private Jacket studentJacket;
    private Book[] books;

    public Locker(Student me) {
        this.owner = me;
        this.number = (int) (Math.random() * 1000);
        this.books = new Book[4];
    }

    public Book getABook(String course) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (b.course.equals(course)) {
                books[i] = null;
                return b;
            }
        }
        return null;
    }

    public void putABook(Book book) {
        for (int i = 0; i < books.length; i++)
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        throw new IllegalArgumentException("Locker already full of books");
    }

    public Jacket getJacket() {
        Jacket jacket = this.studentJacket;
        if (jacket != null) {
            studentJacket = null;
            return jacket;
        } else
            throw new IllegalArgumentException("No jacket in locker");
    }

    public Jacket checkJacket() {
        return studentJacket;
    }

    public void putJacket(Jacket studentJacket) {
        if (this.studentJacket == null)
            this.studentJacket = studentJacket;
        else
            throw new IllegalArgumentException("Jacket is already inside locker");
    }

    @Override
    public String toString() {
        return number + " belongs to " + owner;
    }
}
