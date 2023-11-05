package lecture.lecture5.domain;


public abstract class Shape extends Entity {

    protected String name;

    public Shape(int id, String name) {
        // apel constructor clasa de baza
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();
}
