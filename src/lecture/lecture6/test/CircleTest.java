package lecture.lecture6.test;

import lecture.lecture5.domain.Circle;
import org.junit.jupiter.api.Test;

public class CircleTest {

    @Test
    public void testCircle() {
        Circle c = new Circle(100, "one", 1);
        assert c.getId() == 100;
        assert "one".equals(c.getName());
        assert c.getRadius() == 1;
    }

}
