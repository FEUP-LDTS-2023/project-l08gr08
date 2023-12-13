package bdude.viewer.menu;

import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.menu.LevelNotCleared;
import bdude.viewer.Viewer;

public class LevelNotClearedViewer extends Viewer<LevelNotCleared> {
    public LevelNotClearedViewer(LevelNotCleared model) {
        super(model);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(17, 5), "POKE - DUDE", "#db0404");
        gui.drawText(new Position(17, 9), "YOU LOST :(", "#db0404");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(15, 13 + 2  * i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
        for (int j = 15; j < 31; j++){
            gui.drawText(new Position(j,7), "#", "#FFFFFF");
        }
        for(int j = 3; j <= 11; j++){
            gui.drawText(new Position(15, j), "#", "#FFFFFF");
            gui.drawText(new Position(30, j), "#", "#FFFFFF");
        }
        for(int j = 11; j <= 17; j++){
            gui.drawText(new Position(13, j), "#", "#FFFFFF");
            gui.drawText(new Position(32, j), "#", "#FFFFFF");
        }
        for (int j = 15; j < 30; j++){
            gui.drawText(new Position(j,3), "#", "#FFFFFF");
        }
        for (int j = 13; j < 33; j++){
            gui.drawText(new Position(j,11), "#", "#FFFFFF");
        }
        for (int j = 13; j < 33; j++){
            gui.drawText(new Position(j,17), "#", "#FFFFFF");
        }
    }
}