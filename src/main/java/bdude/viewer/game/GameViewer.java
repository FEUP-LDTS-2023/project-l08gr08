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
        gui.drawText(new Position(0, 0), "#############################################", "#FFFFFF");
        gui.drawText(new Position(44,1), "#", "#FFFFFF");
        gui.drawText(new Position(44,2), "#", "#FFFFFF");
        gui.drawText(new Position(44,3), "#", "#FFFFFF");

        gui.drawText(new Position(17,2), "LEVEL - ", "#ffe600");


        String result2 = null;
        String color2 = null;
        if (getModel().getPlayer().getLives() == 3){
            result2 = "3";
            color2 = "#00FF00";
        }
        if (getModel().getPlayer().getLives() == 2){
            result2 = "2";
            color2 = "#ffe600";
        }
        if (getModel().getPlayer().getLives() == 1){
            result2 = "1";
            color2 = "#ff0000";
        }

        gui.drawText(new Position(29,2), "LIVES:", color2);
        gui.drawText(new Position(36, 2), result2, color2);


        gui.drawText(new Position(25,2), Integer.toString(getModel().getInp()), "#ffe600");
        gui.drawText(new Position(27,2), "#", "#FFFFFF");
        gui.drawText(new Position(27,3), "#", "#FFFFFF");
        gui.drawText(new Position(27,1), "#", "#FFFFFF");

        gui.drawText(new Position(0, 1), "#              #", "#FFFFFF");
        gui.drawText(new Position(0, 2), "#              #", "#FFFFFF");
        gui.drawText(new Position(2, 2), "POKE - DUDE", "#db0404");
        gui.drawText(new Position(0, 3), "#              #", "#FFFFFF");
        gui.drawText(new Position(0, 17), "#                   #", "#FFFFFF");
        gui.drawText(new Position(0,18), "# MOVE COUNTER:", "#FFFFFF");

        gui.drawText(new Position(22,18), "STAGE:", "#FFFFFF");
        gui.drawText(new Position(20,18), "#", "#FFFFFF");
        gui.drawText(new Position(29,18), Integer.toString(getModel().getPlayer().getStage()), "#0000FF");

        String result = null;
        String color = null;
        if (!getModel().getPlayer().getPowerActive()){
            result = "OFF";
            color = "#FF0000";
        }
        else{
            result = "ON";
            color = "#00FF00";
        }
        gui.drawText(new Position(40,18), result, color);

        gui.drawText(new Position(33,18), "POWER:", "#FFFFFF");
        gui.drawText(new Position(31,18), "#", "#FFFFFF");
        gui.drawText(new Position(31,19), "#", "#FFFFFF");
        gui.drawText(new Position(31,17), "#", "#FFFFFF");

        gui.drawText(new Position(0, 19), "#                   #", "#FFFFFF");
        gui.drawText(new Position(44, 19), "#", "#FFFFFF");
        gui.drawText(new Position(44, 18), "#", "#FFFFFF");
        gui.drawText(new Position(44, 17), "#", "#FFFFFF");
        gui.drawText(new Position(0, 20), "#############################################", "#FFFFFF");
        gui.drawText(new Position(16,18), Integer.toString(getModel().getPlayer().getMoveCounter()), "#ffe600");

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
