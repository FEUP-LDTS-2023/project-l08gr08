package bdude.Model.game.menu;

import bdude.model.menu.LevelNotCleared;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LevelNotClearedTest {
    LevelNotCleared notCleared;
    LevelNotCleared notCleared1;
    LevelNotCleared notCleared2;

    @BeforeEach
    void setUp() {
        notCleared = new LevelNotCleared(0);
        notCleared1 = new LevelNotCleared(1);
        notCleared2 = new LevelNotCleared(2);
    }
    @Test
    void checkFirstOp() {
        Assertions.assertTrue(notCleared.isSelected(0));
        Assertions.assertTrue(notCleared1.isSelected(0));
        Assertions.assertTrue(notCleared2.isSelected(0));

        Assertions.assertSame("  RESTART LEVEL ", notCleared.getEntry(notCleared.currentEntry));
        Assertions.assertSame("  RESTART LEVEL ", notCleared1.getEntry(notCleared1.currentEntry));
        Assertions.assertSame("  RESTART LEVEL ", notCleared2.getEntry(notCleared2.currentEntry));
    }
    @Test
    void checkSecondOp() {
        notCleared.nextEntry();
        notCleared1.nextEntry();
        notCleared2.nextEntry();

        Assertions.assertTrue(notCleared.isSelected(1));
        Assertions.assertTrue(notCleared1.isSelected(1));
        Assertions.assertTrue(notCleared2.isSelected(1));

        Assertions.assertSame(" RETURN TO MENU", notCleared.getEntry(notCleared.currentEntry));
        Assertions.assertSame(" RETURN TO MENU", notCleared1.getEntry(notCleared1.currentEntry));
        Assertions.assertSame(" RETURN TO MENU", notCleared2.getEntry(notCleared2.currentEntry));
    }
    @Test
    void checkInp() {
        Assertions.assertEquals(0,notCleared.getInp());
        Assertions.assertEquals(1,notCleared1.getInp());
        Assertions.assertEquals(2,notCleared2.getInp());
    }
}
