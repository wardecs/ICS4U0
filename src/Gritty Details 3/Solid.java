/**
 * @author Daniel Voznyy
 * Ms. Krasteva
 * March 18, 2019
 * A basic template for shapes, 2D and 3D to use for basic calculations
 */

public abstract class Solid {
    String name;

    Solid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract double volume();

    abstract double perimeter();

    abstract double surfaceArea();
}
