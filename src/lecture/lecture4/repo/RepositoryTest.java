package lecture.lecture4.repo;

import lecture.lecture4.Circle;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        try {
            repo.add(new Circle("1", 1));
        } catch (RepositoryException e) {
            // Aici nu are trebui sa apara erori
            assert false;

        }
    }

    @Test
    public void testAddException() {
        Repository repo = new Repository();
        try {
            repo.add(new Circle("1", 1));
            repo.add(new Circle("1", 1));
            assert false;
        } catch (RepositoryException e) {
            // Aici ar trebui sa fie totul ok
            assert true;

        }
    }

}
