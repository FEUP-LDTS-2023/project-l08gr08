package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.Position;
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
        gui.drawText(new Position(0, 0), "################", "#FFFFFF");
        gui.drawText(new Position(0, 1), "#              #", "#FFFFFF");
        gui.drawText(new Position(0, 2), "# POKE - DUDE  #", "#FFFFFF");
        gui.drawText(new Position(0, 3), "#              #", "#FFFFFF");
        gui.drawText(new Position(0, 17), "#                   #", "#FFFFFF");
        gui.drawText(new Position(0,18), "# MOVE COUNTER: ", "#FFFFFF");
        gui.drawText(new Position(20,18), "#", "#FFFFFF");
        gui.drawText(new Position(0, 19), "#                   #", "#FFFFFF");
        gui.drawText(new Position(0, 20), "#####################", "#FFFFFF");
        gui.drawText(new Position(16,18), Integer.toString(getModel().getPlayer().getMoveCounter()), "#FFFFFF");
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
