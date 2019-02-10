package Exercise1;

public class Animal {
    private String name;
    private boolean tired;
    private boolean hungry;
    private double weight;

    public Animal(String n, double w) { //class constructor
        name = n;
        tired = true;
        hungry = true;
        weight = w;
    }

    public void feed(String v){ //feed method
        hungry = false;
        if(v.equals("vegetables"))
            weight += 2;
        if(v.equals("meat"))
            weight += 4;
        else
            weight += 1;
    }

    public void sleep(){
        tired = false;
        weight -= 3;
    }
} //Exercise1.Animal class