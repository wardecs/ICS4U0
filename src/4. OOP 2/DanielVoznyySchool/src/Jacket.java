public class Jacket {
    Student owner;

    public Jacket(Student me) {
        this.owner = me;
    }

    @Override
    public String toString() {
        return "Jacket owner: " + owner;
    }
}
