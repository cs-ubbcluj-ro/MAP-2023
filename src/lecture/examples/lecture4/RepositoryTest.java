package lecture.examples.lecture4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepositoryTest {

    private Repository repo;

    @BeforeEach
    void setUp() {
        repo = new Repository();
        repo.add(new Book("a", "b", 10));
        repo.add(new Book("c", "d", 20));
        repo.add(new Book("e", "f", 25));
    }

    @Test
    void add() {
        assert repo.size() == 3;
        repo.add(new Book("f", "e", 10));
        assert repo.size() == 4;
    }

    @Test
    void remove() {
        repo.remove(new Book("e", "f", 25));
        assert repo.size() == 2;
    }

    @Test
    void size() {
        assert repo.size() == 3;
        repo.add(new Book("a", "c", 20));
        assert repo.size() == 4;
    }
}