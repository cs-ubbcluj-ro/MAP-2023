package lecture.lecture6.domain;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    /*
    Entity este o entitate generica care nu reprezinto un concept
    concret din domeniul problemei
     */

    private static final long serialVersionUID = 1000L;

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
