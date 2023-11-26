import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testGetX() {
        Position position = new Position(5, 10);
        assertEquals(5, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(5, 10);
        assertEquals(10, position.getY());
    }

    @Test
    public void testEquals() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(3, 8);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Test
    public void testEqualsWithDifferentObject() {
        Position position = new Position(5, 10);
        Object notPosition = new Object();

        assertNotEquals(position, notPosition);
    }

}
