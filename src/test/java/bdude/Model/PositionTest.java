package bdude.Model;

import bdude.model.Position;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java.io.IOException;
public class PositionTest {

    @Test
    public void testGetLeft() {
        Position position = new Position(1, 2);
        Position expectedPosition = new Position(0, 2);

        Position actualPosition = position.getLeft();
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void testGetRight() {
        Position position = new Position(1, 2);
        Position expectedPosition = new Position(2, 2);

        Position actualPosition = position.getRight();
        Assertions.assertEquals(expectedPosition, actualPosition);
    }


    @Test
    public void testGetBlockLeft() {
        Position position = new Position(0, 0);
        Position expectedPosition = new Position(-1, 0);

        Position actualPosition = position.getBlockLeft();
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void testGetBlockRight() {
        Position position = new Position(0, 0);
        Position expectedPosition = new Position(1, 0);

        Position actualPosition = position.getBlockRight();
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void testGetX() {
        Position position = new Position(10, 20);
        int expectedX = 10;

        int actualX = position.getX();
        Assertions.assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        Position position = new Position(10, 20);
        int expectedY = 20;

        int actualY = position.getY();
        Assertions.assertEquals(expectedY, actualY);
    }
}
