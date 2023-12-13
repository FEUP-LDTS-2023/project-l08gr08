package bdude.viewer.menu;

import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.menu.LevelCleared;
import bdude.viewer.Viewer;

public class LevelClearedViewer extends Viewer<LevelCleared> {
    public LevelClearedViewer(LevelCleared model) {
        super(model);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(17, 5), "POKE - DUDE", "#db0404");
        gui.drawText(new Position(18, 9), "GAME OVER", "#db0404");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(15, 13 + 2 * i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        /*
        for (int j = 16; j < 30; j++){
            gui.drawText(new Position(j,7), "#", "#FFFFFF");
        }
        for (int j = 16; j < 30; j++){
            gui.drawText(new Position(j,3), "#", "#FFFFFF");
        }
        for (int j = 16; j < 30; j++){
            gui.drawText(new Position(j,19), "#", "#FFFFFF");
        }
        for (int j = 3; j <= 19; j++){
            gui.drawText(new Position(15,j), "#", "#FFFFFF");
        }
        for (int j = 3; j <= 19; j++){
            gui.drawText(new Position(29,j), "#", "#FFFFFF");
        }
        */
    }
}

