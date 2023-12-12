package bdude.viewer.menu;

import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.menu.Menu;
import bdude.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(33, 5), "POKE - DUDE", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(34, 9 + 2 * i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
        for (int j = 31; j < 45; j++){
            gui.drawText(new Position(j,7), "#", "#FFFFFF");
        }
        for (int j = 31; j < 45; j++){
            gui.drawText(new Position(j,3), "#", "#FFFFFF");
        }
        for (int j = 31; j < 45; j++){
            gui.drawText(new Position(j,19), "#", "#FFFFFF");
        }
        for (int j = 3; j <= 19; j++){
            gui.drawText(new Position(31,j), "#", "#FFFFFF");
        }
        for (int j = 3; j <= 19; j++){
            gui.drawText(new Position(45,j), "#", "#FFFFFF");
        }
    }
}
