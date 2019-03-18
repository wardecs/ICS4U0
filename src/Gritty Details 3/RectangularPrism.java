public class RectangularPrism extends Solid {
    private double width, length, height;

    public RectangularPrism(String name, double w, double d, double h){
        super(name);
        this.width = w;
        this.length = d;
        this.height = h;
    }

    public double volume() {
        return width * length * height;
    }

    public double perimeter() {
        return Double.NaN;
    }

    public double surfaceArea() {
        return 2 * (width * length + height * length + height * width);
    }
}
