package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Element;
import bdude.model.game.levels.Level;
import bdude.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Level> {
    public GameViewer(Level level) {
        super(level);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElements(gui, getModel().getItems(), new ItemViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getBlocks(), new BlockViewer());
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) drawElement(gui, element, viewer);
    }
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
