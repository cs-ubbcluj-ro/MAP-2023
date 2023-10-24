package seminar.grupa322.seminar2.repository;

import seminar.grupa322.seminar2.domain.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

public class Repository<T> implements Iterable<T> {
    private final ArrayList<T> data;

    public Repository() {
        this.data = new ArrayList<T>();
    }

    public void add(T entity) {
        data.add(entity);
    }

    public T get(int poz) {
        if (poz < this.data.size() - 1 && poz > -1) return data.get(poz);
        throw new NoSuchElementException();
    }

    public T getById(int id) {
        for (T entity : data) {
            Entity entity1 = (Entity) entity;
            if (entity1.getID() == id) {
                return entity;
            }
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return data.size();
    }

    public void delete(T entity) {
        this.data.remove(entity);
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}