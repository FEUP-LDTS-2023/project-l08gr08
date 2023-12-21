package bdude.Viewer;

import bdude.gui.GUI;
import bdude.model.game.elements.Block;
import bdude.viewer.game.BlockViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BlockViewerTest {
    private Block block;
    private Block movableBlock;
    private BlockViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        block = new Block(0,0);
        movableBlock = new Block(1,1);
        movableBlock.makeMovable();

        viewer = new BlockViewer();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void testDraw1() {
        viewer.draw(block,gui);
        Mockito.verify(gui, Mockito.times(1)).drawBlock(block.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawMovableBlock(block.getPosition());
    }
    @Test
    void testDraw2() {
        viewer.draw(movableBlock, gui);
        Mockito.verify(gui, Mockito.times(0)).drawBlock(movableBlock.getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawMovableBlock(movableBlock.getPosition());
    }
}
