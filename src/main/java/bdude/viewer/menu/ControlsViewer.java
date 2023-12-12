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
        gui.drawText(new Position(33, 5), "POKE - DUDE", "#db0404");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(26,  8 + 2 * i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
