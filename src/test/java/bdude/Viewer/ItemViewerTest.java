package bdude.Viewer;

import bdude.gui.GUI;
import bdude.model.game.elements.Item;
import bdude.viewer.game.ItemViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ItemViewerTest {
    private Item item1;
    private Item item2;
    private Item item3;
    private ItemViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        item1 = new Item(0,0);
        item1.switchId(1);

        item2 = new Item(0,0);
        item2.switchId(2);

        item3 = new Item(0,0);
        item3.switchId(3);

        viewer = new ItemViewer();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawItem1() {
        viewer.draw(item1, gui);
        Mockito.verify(gui, Mockito.times(1)).drawItem1(item1.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawItem2(item1.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawItem3(item1.getPosition());
    }
    @Test
    void drawItem2() {
        viewer.draw(item2, gui);
        Mockito.verify(gui, Mockito.times(0)).drawItem1(item2.getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawItem2(item2.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawItem3(item2.getPosition());
    }
    @Test
    void drawItem3() {
        viewer.draw(item3, gui);
        Mockito.verify(gui, Mockito.times(0)).drawItem1(item3.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawItem2(item3.getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawItem3(item3.getPosition());
    }
}
