package lecture.lecture4;

import java.io.Serializable;
import java.util.Objects;

public class Circle extends Shape  implements Serializable {

    private double radius;

    public Circle(String name) {
        super(name);
    }

    public Circle(String name, double radius) {
        this(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
