package lecture.lecture4;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList<Shape> data = new LinkedList<>();
        assert data.size() == 0;
        data.add(new Circle("1", 1));
        data.add(new Circle("2", 2));
        assert data.size() == 2;
    }
}
