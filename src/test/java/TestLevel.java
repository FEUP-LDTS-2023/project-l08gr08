import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestLevel {

    private Level level;

    @BeforeEach
    public void setUp() {
        level = new Level(1);
        level.createWalls();
    }

    @Test
    public void testMovePlayer() {
        Position newPosition = new Position(5, 5);
        level.movePlayer(newPosition);
        assertEquals(newPosition, level.getPlayer().getPosition());
    }

}

