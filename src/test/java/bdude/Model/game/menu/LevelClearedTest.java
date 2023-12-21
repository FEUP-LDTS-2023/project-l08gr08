package bdude.Model.game.menu;

import bdude.model.menu.LevelCleared;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LevelClearedTest {
    LevelCleared cleared;
    LevelCleared cleared1;
    LevelCleared cleared2;

    @BeforeEach
    void setUp() {
        cleared = new LevelCleared(0);
        cleared1 = new LevelCleared(1);
        cleared2 = new LevelCleared(2);
    }
    @Test
    void checkFirstOp() {
        Assertions.assertTrue(cleared.isSelected(0));
        Assertions.assertTrue(cleared1.isSelected(0));
        Assertions.assertTrue(cleared2.isSelected(0));

        Assertions.assertSame("GO TO NEXT LEVEL ", cleared.getEntry(cleared.currentEntry));
        Assertions.assertSame("GO TO NEXT LEVEL ", cleared1.getEntry(cleared1.currentEntry));
        Assertions.assertSame("GO TO NEXT LEVEL ", cleared2.getEntry(cleared2.currentEntry));
    }
    @Test
    void checkSecondOp() {
        cleared.nextEntry();
        cleared1.nextEntry();
        cleared2.nextEntry();

        Assertions.assertTrue(cleared.isSelected(1));
        Assertions.assertTrue(cleared1.isSelected(1));
        Assertions.assertTrue(cleared2.isSelected(1));

        Assertions.assertSame(" RETURN TO MENU  ", cleared.getEntry(cleared.currentEntry));
        Assertions.assertSame(" RETURN TO MENU  ", cleared1.getEntry(cleared1.currentEntry));
        Assertions.assertSame(" RETURN TO MENU  ", cleared2.getEntry(cleared2.currentEntry));
    }
    @Test
    void checkInp() {
        Assertions.assertEquals(0,cleared.getInp());
        Assertions.assertEquals(1,cleared1.getInp());
        Assertions.assertEquals(2,cleared2.getInp());
    }
}
