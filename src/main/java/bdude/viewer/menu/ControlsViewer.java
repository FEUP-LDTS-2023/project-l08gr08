package bdude.viewer.menu;

import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.menu.Controls;
import bdude.viewer.Viewer;

public class ControlsViewer extends Viewer<Controls> {
    public ControlsViewer(Controls model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {

        gui.drawText(new Position(17, 5), "POKE - DUDE", "#db0404");
        gui.drawText(new Position(0, 0), "#############################################", "#FFFFFF");
        gui.drawText(new Position(0, 39), "#############################################", "#FFFFFF");
        for(int i = 0; i < 45; i++){
            gui.drawText(new Position(0, i), "#", "#FFFFFF");
            gui.drawText(new Position(44, i), "#", "#FFFFFF");
        }

        gui.drawText(new Position(15, 4), "#             #", "#ffffff");
        gui.drawText(new Position(15, 5), "#             #", "#ffffff");
        gui.drawText(new Position(29, 5), "#", "#ffffff");
        gui.drawText(new Position(17, 5), "POKE - DUDE", "#db0404");
        gui.drawText(new Position(15, 6), "#             #", "#ffffff");
        for (int i = 0; i < getModel().getNumberEntries() - 1; i++) {
            gui.drawText(new Position(8,  9 + 2 * i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#00FF00");
        }
        for (int i = 5; i < 42; i++){
            gui.drawText(new Position(i,7), "#", "#ffffff");
        }
        for (int j = 15; j < 30; j++){
            gui.drawText(new Position(j,3), "#", "#FFFFFF");
        }
        for(int j = 7; j <= 31; j++){
            gui.drawText(new Position(5,j), "#", "#ffffff");
        }
        for(int j = 7; j <= 31; j++){
            gui.drawText(new Position(41,j), "#", "#ffffff");
        }

        gui.drawText(new Position(19,29), getModel().getEntry(9),getModel().isSelected(9) ? "#FFD700" : "#FFFFFF" );

        for (int i = 5; i < 42; i++){
            gui.drawText(new Position(i,27), "#", "#ffffff");
        }
        for (int i = 5; i < 42; i++){
            gui.drawText(new Position(i,31), "#", "#ffffff");
        }
    }
}
