package bdude.Viewer;

import bdude.gui.GUI;
import bdude.model.game.elements.Wall;
import bdude.viewer.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallViewerTest {
    private Wall wall;
    private WallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wall = new Wall(0,0);
        viewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawWall() {
        viewer.draw(wall,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
}
