package bdude.Model.game.levels;

import bdude.model.game.levels.Level;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import bdude.model.Position;
import bdude.model.game.elements.*;

import java.util.List;

public class LevelTest {

    private Level level;

    @BeforeEach
    public void setUp() {
        level = new Level(5, 5);
    }

    @Test
    public void testIncrementEnemyCounter() {
        // Create a mock enemy
        Enemy mockEnemy = mock(Enemy.class);
        when(mockEnemy.getPosition()).thenReturn(new Position(1, 1));

        // Set up the level with the mock enemy
        level.setEnemies(List.of(mockEnemy));

        // Call the method under test
        level.incrementEnemyCounter();

        // Verify that the enemy's counter has been incremented
        verify(mockEnemy).addCounter();
    }
    // Add more tests for other methods in the Level class

    // Example of testing isEmpty method
    @Test
    public void testIsEmptyWithOccupiedPosition() {
        // Create a mock wall
        Wall mockWall = mock(Wall.class);
        when(mockWall.getPosition()).thenReturn(new Position(2, 2));

        // Set up the level with the mock wall
        level.setWalls(List.of(mockWall));

        // Call the method under test
        boolean result = level.isEmpty(new Position(2, 2));

        // Verify that the position is not empty
        assertFalse(result);
    }
}
