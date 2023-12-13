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
        gui.drawText(new Position(17, 5), "POKE - DUDE", "#db0404");
        gui.drawText(new Position(0, 0), "#############################################", "#FFFFFF");
        gui.drawText(new Position(0, 39), "#############################################", "#FFFFFF");
        for(int i = 0; i < 45; i++){
            gui.drawText(new Position(0, i), "#", "#FFFFFF");
            gui.drawText(new Position(44, i), "#", "#FFFFFF");
        }

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(17, 9 + 2 * i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
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
    }
}
