package lecture.lecture2;

public class ShapesProgram {
    public static void main(String[] args) {
//        Shape shp = new Shape("generic shape");
        Circle c1 = new Circle("my circle", 1);
        Circle c2 = new Circle("my circle", 1);
        System.out.println(c1 == c1);
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c1));
        System.out.println(c1.equals(c2));

        System.out.println(c1);
    }
}
