package seminar.grupa321.seminar3;

public abstract class Entity {
    /*
    Entity este o entitate generica care nu reprezinto un concept
    concret din domeniul problemei
     */

    // data membru read-only - odata setata nu este modificata
    // atribut final == constanta
    private final int id;

    public Entity(int id) {
        // singurul constructor obliga la furnizarea unui ID pentru fiecare obiect
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
