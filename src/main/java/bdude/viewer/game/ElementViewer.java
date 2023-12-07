package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw (T element, GUI gui);
}
