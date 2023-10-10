package lecture.examples.lecture2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

interface MyComparable {
    public boolean compareTo(Object o);
}

interface GraphicallyRepresentable {
    public void draw();
}

class Complex implements MyComparable, GraphicallyRepresentable {
    private double real, imaginary;

    Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    private double modulus() {

        return sqrt(pow(this.real, 2) + pow(this.imaginary, 2));
    }

    @Override
    public boolean compareTo(Object c) {
//        if (c.getClass() != Complex.class)
//            return false;
        if (!(c instanceof Complex))
            return false;
        Complex number = (Complex) c;
        return this.modulus() < number.modulus();
    }

    @Override
    public void draw() {

        System.out.println("Drawing: Ox: " + this.real + ", Oy: " + this.imaginary);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }
}

class ComplexWithId extends Complex {
    private int id;

    public ComplexWithId(double re, double im, int id) {
        super(re, im);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ComplexWithId{" +
                "id=" + id +
                "} " + super.toString();
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Complex c1 = new Complex(1, 2);
        MyComparable c2 = new Complex(1, 3);
        System.out.println(c1 + " compareTo " + c2 + ": " + c1.compareTo(c2));
        c1.draw();

        System.out.println(c1 + " instance of Complex: " + (c1 instanceof Complex));
        System.out.println(c1 + " instance of MyComparable: " + (c1 instanceof MyComparable));
        System.out.println(c1 + " instance of GraphicallyRepresentable: " + (c1 instanceof GraphicallyRepresentable));
        System.out.println(c1 + " instance of ComplexWithId: " + (c1 instanceof ComplexWithId));
        Complex cWithId = new ComplexWithId(12, -1, 1);

        if (cWithId instanceof ComplexWithId) {
            ComplexWithId c3 = (ComplexWithId) cWithId;
            System.out.println(c3.getId());
        }

        System.out.println(cWithId + " instance of ComplexWithId: " + (cWithId instanceof ComplexWithId));
        System.out.println(cWithId + " instance of GraphicallyRepresentable: " + (cWithId instanceof GraphicallyRepresentable));
    }
}


