package seminar.grupa321.seminar2.domain;

//Medeea Apascaritei
public abstract class Entity {
    protected int id;

    public Entity(int id) {
        // Fortam utilizatorul clasei să furnizeze câmpul id în momentul construcției
        // obiectului
        this.id = id;
    }

    public int getId() {
        return id;
    }
}