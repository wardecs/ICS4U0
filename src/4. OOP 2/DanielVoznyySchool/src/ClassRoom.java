public class ClassRoom {
    String name;
    String teacher;

    public ClassRoom(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    Boolean enter(Student me) {
        return true;
    }
}
