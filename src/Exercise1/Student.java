public class Student {
    public String name;
    public int mark1;
    public int mark2;
    public double average;

    public Student(String n) { //student constructor
        name = n;
        mark1 = 0;
        mark2 = 0;
        average = 0.0;
    }

    public void setMarks(int x, int y) { //set student marks
        mark1 = x;
        mark2 = y;
    }

    public void calcAverage() { //check average of student's 2 marks
        average = (mark1 + mark2) / 2;
    }

    public String message() { //print student average
        return name + " You got an " + average;
    }
} //Exercise1.Student class