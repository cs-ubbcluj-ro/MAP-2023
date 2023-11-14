package lecture.lecture6.domain;


public abstract class Shape extends Entity {

    private static final long serialVersionUID = 1000L;

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
