package Evaluation;

import Exercise1.Car;

public class Driver {
    public static void main(String[] args) {
        //create bank accounts
        Bank_Account mainAccount = new Bank_Account(1294786574, 100, "Checking", 0.2f);
        Bank_Account secondaryAccount = new Bank_Account(314761965, 100, "Savings", 0.1f);

        mainAccount.deposit(100); //make deposit
        mainAccount.applyInterest(); //apply interest
        System.out.println("Your " + mainAccount.getType() + " account has " + Math.round(mainAccount.getBalance() * 100) / 100.0 + "$ left"); //print money remaining rounded to 2 decimal places

        //instantiate cars
        Car dailyDriver = new Car("Honda", "Accord", 0, 100);
        Car mountainCar = new Car("Chevrolet", "Traverse", 0, 200);

        dailyDriver.gasUp(); //fill car
        dailyDriver.drive(20); //drive


    }
} //Evaluation.Driver class