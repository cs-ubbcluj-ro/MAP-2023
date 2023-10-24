package lecture.lecture4.repo;

import lecture.lecture4.IIterator;
import lecture.lecture4.LinkedList;
import lecture.lecture4.Shape;

public class Repository {

    private LinkedList<Shape> data = new LinkedList<>();

    public void add(Shape shape) throws RepositoryException {
        if (shape == null) {
            // NullPointerException este RuntimeException
            // deci nu trebuie declarat explicit
            throw new NullPointerException("Shape cannot be null");
        }

        if (data.size() == 0) {
            data.add(shape);
            return;
        }

        IIterator<Shape> iter = data.iterator();
        while (iter.isValid()) {
            Shape shp = iter.getValue();

            if (shape.equals(shp)) {
                throw new DuplicateObjectException("Duplicate objects cannot be added");
            }
            iter.nextNode();
        }
    }
}
