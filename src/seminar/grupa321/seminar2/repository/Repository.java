package seminar.grupa321.seminar2.repository;

///Aluas Alin

import seminar.grupa321.seminar2.domain.Entity;

import java.util.ArrayList;

public class Repository<T extends Entity> {
    ArrayList<T> elems;

    public int getSize() {
        return elems.size();
    }

    public T getAt(int pos) {
        return elems.get(pos);
    }

    public Boolean findByID(int id) {
        for (T elem : elems)
            if (elem.getId() == id) return true;
        return false;
    }

    public T getById(int id) {
        for (T elem : elems)
            if (elem.getId() == id) return elem;
        return null;
    }

    public Boolean deleteById(int id) {
        if (!findByID(id)) return false;
        elems.remove(getById(id));
        return true;
    }

    public void addEntity(T elem) {
        if (!findByID(elem.getId())) elems.add(elem);
    }
}
