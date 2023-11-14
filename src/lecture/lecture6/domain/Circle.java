package lecture.lecture6.domain;

import java.util.Objects;

public class Circle extends Shape {

    private static final long serialVersionUID = 1000L;

    private double radius;

    public Circle(int id, String name) {
        super(id, name);
    }

    public Circle(int id, String name, double radius) {
        // in Java putem avea oricati constructori
        // this() apeleaza alt constructor al aceleasi clase
        this(id, name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
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
        return this.getId() == circle.getId() && Objects.equals(this.getName(), circle.getName()) && Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public String toString() {
        return "Circle{" + getId() +
                ", radius=" + radius +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
