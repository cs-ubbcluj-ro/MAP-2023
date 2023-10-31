package seminar.grupa321.seminar3.repo;

import seminar.grupa321.seminar3.Entity;

import java.util.ArrayList;
import java.util.Collection;

//Andreica David & Andries Andrei
public class MemoryRepository<T extends Entity> extends AbstractRepository<T> {
    @Override
    public void add(T o) throws RepositoryException {
        if (o == null)
            throw new IllegalArgumentException();
        if (find(o.getId()) != null)
            throw new DuplicateObjectException("Dublu");
        this.data.add(o);
    }

    @Override
    public void remove(int id) throws RepositoryException {
        for (T e : this.data) {
            if (e.getId() == id) {
                this.data.remove(e);
            }
        }
    }

    @Override
    public T find(int id) {
        for (T e : this.data) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return new ArrayList(this.data);
    }
}
