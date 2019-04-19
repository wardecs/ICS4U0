public class ClassRoom {
    String name;
    String teacher;

    public ClassRoom(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    Boolean enter(Student student) {
        System.out.println("Student " + student + " came into class " + name + " taught by " + teacher);
        if (student.myLocker == null) {
            student.sendToOffice("Get a locker");
            return false;
        }
        if (student.myJacket != null) {
            student.myLocker.putJacket(student.myJacket); //TODO set student's jacket to null inside another method?
            student.myJacket = null;
            return false;
        }
        if (student.books.length < 2) { //TODO are they supposed to pass the number of books needed?
            student.sendToOffice("Class " + name + " requires 2 books");
            return false;
        }
        return true;
    }
}
