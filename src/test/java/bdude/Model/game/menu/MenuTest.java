package bdude.Model.game.menu;

import bdude.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {
    Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }
    @Test
    void firstEntry() {
        Assertions.assertEquals(0, menu.currentEntry);
    }
    @Test
    void nextEntries(){
        Assertions.assertEquals(0, menu.currentEntry);
        Assertions.assertSame(" LEVEL - 1", menu.getEntry(menu.currentEntry));
        menu.nextEntry();
        Assertions.assertEquals(1,menu.currentEntry);
        Assertions.assertSame(" LEVEL - 2", menu.getEntry(menu.currentEntry));
        menu.nextEntry();
        Assertions.assertEquals(2,menu.currentEntry);
        Assertions.assertSame(" LEVEL - 3", menu.getEntry(menu.currentEntry));
        menu.nextEntry();
        Assertions.assertEquals(3,menu.currentEntry);
        Assertions.assertSame(" CONTROLS", menu.getEntry(menu.currentEntry));
        menu.nextEntry();
        Assertions.assertEquals(4,menu.currentEntry);
        Assertions.assertSame("   EXIT", menu.getEntry(menu.currentEntry));
        menu.nextEntry();
        Assertions.assertEquals(0,menu.currentEntry);
        Assertions.assertSame(" LEVEL - 1", menu.getEntry(menu.currentEntry));
    }
    @Test
    void prevEntries() {
        Assertions.assertEquals(0, menu.currentEntry);
        menu.previousEntry();
        Assertions.assertEquals(4, menu.currentEntry);
        menu.previousEntry();
        Assertions.assertEquals(3, menu.currentEntry);
        menu.previousEntry();
        Assertions.assertEquals(2, menu.currentEntry);
        menu.previousEntry();
        Assertions.assertEquals(1, menu.currentEntry);
        menu.previousEntry();
        Assertions.assertEquals(0, menu.currentEntry);
        menu.previousEntry();
    }
    @Test
    void Level1Chosen() {
        Assertions.assertTrue(menu.isSelected(0));
    }
    @Test
    void Level2Chosen() {
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(1));
    }
    @Test
    void Level3Chosen() {
        menu.nextEntry();
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(2));
    }
    @Test
    void ControlsChosen() {
        menu.nextEntry();
        menu.nextEntry();
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(3));
    }
    @Test
    void ExitChosen() {
        menu.nextEntry();
        menu.nextEntry();
        menu.nextEntry();
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(4));
    }
}