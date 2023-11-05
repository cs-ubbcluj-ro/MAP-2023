package lecture.lecture5.repo;

import lecture.lecture5.domain.Entity;

import java.util.Collection;

public interface IRepository<T extends Entity> extends Iterable<T> {
    public void add(T o) throws RepositoryException;

    public void remove(int id) throws RepositoryException;

    public T find(int id);

    public Collection<T> getAll();
}
