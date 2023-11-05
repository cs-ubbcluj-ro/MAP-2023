package lecture.lecture5.repo;

import lecture.lecture5.domain.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRepository<T extends Entity> implements IRepository<T> {

    protected List<T> data = new ArrayList<>();

    @Override
    public Iterator<T> iterator() {
        // returnam un iterator pe un shallow copy :) al campului data
        return new ArrayList<T>(data).iterator();
//        return data.iterator();
    }
}
