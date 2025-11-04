package Modul5.soal1;

public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getHeight() {
        return height;
    }
    
    protected double area() {
        return 2 * Math.PI * radius * (height + radius);
    }

    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}