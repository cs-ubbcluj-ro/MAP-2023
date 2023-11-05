package lecture.lecture5.repo;

import lecture.lecture5.domain.Entity;

import java.util.ArrayList;
import java.util.Collection;

public class MemoryRepository<T extends Entity> extends AbstractRepository<T> {
    @Override
    public void add(T o) throws RepositoryException {
        if (o == null) {
            // este RuntimeException
            throw new IllegalArgumentException();
        }
        if (find(o.getId()) != null) {
            // checked Exception
            throw new DuplicateObjectException("Cannot duplicate repository objects!");
        }

        this.data.add(o);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public T find(int id) {
        for (T o : data) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    @Override
    public Collection<T> getAll() {
        // returnam o copie
        return new ArrayList<>(data);
    }
}
