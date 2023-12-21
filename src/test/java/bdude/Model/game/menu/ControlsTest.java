package bdude.Model.game.menu;

import bdude.model.menu.Controls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControlsTest {
    Controls controls;

    @BeforeEach
    void setUp(){
        controls = new Controls();
    }
    @Test
    void onlyEntry() {
        Assertions.assertEquals(9, controls.currentEntry);
        Assertions.assertSame("GO BACK",controls.getEntry(controls.currentEntry));
    }
    @Test
    void onlyEntry2() {
        Assertions.assertTrue(controls.isSelected(9));
    }
}
