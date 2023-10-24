package seminar.grupa322.seminar2.domain;

/// Hileaga Maria-Georgiana
public abstract class Entity {
    protected int ID;

    public Entity(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
