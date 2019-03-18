import java.util.Random;

public class Excercise1Driver {
    public static void main(String[] args) {
        Student[] students = {new Student("Daniel"), new Student("Enfei"), new Student("Abhi"), new Student("Daniel's Clone"), new Student("Daniel's failed clone")}; //create a list of students
        for (Student student : students) { //go through each student
            student.setMarks(new Random().nextInt(100), new Random().nextInt(100)); //set marks to a random number between 0 and 100
            student.calcAverage(); //calculate average from both marks
            System.out.println(student.message()); //print average
        }

        Student[] tempStudents = students; //create temp array from student array
        students = new Student[10]; //set student array length to 10
        for (int i = 0; i < tempStudents.length; i++) { //add students from temp array to the new one
            students[i] = tempStudents[i];
        }
        students[8] = new Student("John"); //add a student at the 8th position of the new array
        students[8].setMarks(100, 100);

        //variables for calculating average
        double overallAverage = 0;
        int numberOfStudents = 0;

        for (Student student : students) { //for every student in the array
            if (student == null) //if the student does not exist
                continue; //skip the student

            student.calcAverage(); //calculate their mark average
            overallAverage += student.average; //add their average to overall
            numberOfStudents++; //count student
        }
        overallAverage /= numberOfStudents; //calculate proper average
        System.out.println("\nThe overall average of the students is: " + overallAverage); //print it

        //create cars
        Car firstCar = new Car("Ford", "T", 0, 10);
        Car tesla = new Car("Tesla", "S", 0, 0);
        Car camry = new Car("Toyota", "Camry", 0, 100);
        Car accord = new Car("Honda", "Accord", 0, 100);
        Car mountainCar = new Car("Chevrolet", "Traverse", 0, 200);

        firstCar.gasUp(); //fill up the car
        firstCar.drive(10); //drive

        //try to fill a tesla with gas
        System.out.println("\nLet my try filling up my Tesla...");
        tesla.gasUp();
        tesla.gasUp();
        tesla.gasUp();
        System.out.println("Oh right, my Tesla can't take gas");

        //create houses
        House home = new House(12, "Cool road", "Toronto", "Ontario", "L4A 000", 100, false, 1);
        House school = new House(20, "Tillplain Rd", "North York", "Ontario", "M3H 5R2", 2000, false, 2);
        House nearestMall = new House(1, "Promenade Cir", "Vaughan", "Ontario", "L4J 4P8", 5000, false, 3);
        House cnTower = new House(301, "Front St W", "Toronto", "Ontario", "M5V 2T6", 5000, false, 3);
        House walmart = new House(700, "Center St", "Thornhill", "Ontario", "L4J 0A7", 2000, false, 1);

        System.out.println("\nThe home's address is:");
        home.displayAddress(); //display the address of home

        //create animals
        Animal dog = new Animal("Sparky", 20);
        Animal lizard = new Animal("Lizzy", 0.1);
        Animal cat = new Animal("Mittens", 15);
        Animal bird = new Animal("Charlie", 0.2);
        Animal fish = new Animal("Nemo", 0.1);

        dog.feed("meat"); //feed the dog meat
        dog.sleep(); //make dog sleep
    }
} //Driver class