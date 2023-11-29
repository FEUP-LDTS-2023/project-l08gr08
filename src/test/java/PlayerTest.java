import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PlayerTest {

    @Test
    public void testDefaultPlayerPosition() {
        Player player = new Player(0, 0);

        assertEquals(0, player.getPosition().getX());
        assertEquals(0, player.getPosition().getY());
    }
    @Test
    public void testMoveRight() {
        Player player = new Player(0, 0);
        Position newPosition = player.moveRight();

        assertEquals(1, newPosition.getX());
        assertEquals(0, newPosition.getY());
    }
    @Test
    public void testMoveLeft() {
        Player player = new Player(1, 0);
        Position newPosition = player.moveLeft();

        assertEquals(0, newPosition.getX());
        assertEquals(0, newPosition.getY());
    }
    @Test
    public void testSwitchDirection() {
        Player player = new Player(0, 0);
        boolean initialDirection = player.getDirection();

        player.switchDirection();
        boolean newDirection = player.getDirection();

        assertNotEquals(initialDirection, newDirection);
    }
    @Test
    public void testNextStage() {
        Player player = new Player(0, 0);
        int initialStage = player.getStage();

        player.nextStage();
        int newStage = player.getStage();

        assertNotEquals(initialStage, newStage);
    }
}
