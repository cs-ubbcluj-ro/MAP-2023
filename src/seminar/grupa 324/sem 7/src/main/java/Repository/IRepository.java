package Repository;

import Domain.Entity;

import java.util.Collection;

public interface IRepository<T extends Entity> extends Iterable<T> {
    public void add(T entity) throws DuplicateEntityException;
    public void update(T entity);
    public void remove(int id);
    public T find(int id);
    public Collection<T> getAll();
}
