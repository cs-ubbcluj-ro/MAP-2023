package Repository;

import Domain.Entity;

import java.util.Collection;

public interface IRepository<T extends Entity> extends Iterable<T> {
    void add(T entity) throws DuplicateEntityException;
    void remove(int id);
    T findById(int id);
    Collection<T> getAll();
}
