package lecture.lecture6.repo;

import lecture.lecture6.domain.Entity;

import java.util.Collection;

public interface IRepository<T extends Entity> extends Iterable<T> {
    public void add(T o) throws RepositoryException;

    public void remove(int id) throws RepositoryException;

    public T find(int id);

    // program to an interface, not an implementation
    public Collection<T> getAll();
}
