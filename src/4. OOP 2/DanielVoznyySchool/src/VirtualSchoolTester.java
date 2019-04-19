public class VirtualSchoolTester {
    public static void main(String[] args) {
        Student student = new Student("Daniel");
        ClassRoom classRoom = new ClassRoom("ICS", "Ms. Krasteva");

        if(classRoom.enter(student)){
            System.out.println(student + " was allowed into class");
        }else{
            System.out.println(student + " was not allowed into class");

        }

//        System.out.println(student + " was sent to the office and not allowed into class");
//        System.out.println(student + " was sent to his locker and not allowed into class");
    }
}
