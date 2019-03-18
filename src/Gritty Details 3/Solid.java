public abstract class Solid {
    String name;

    Solid(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract double volume();

    abstract double perimeter();

    abstract double surfaceArea();
}
