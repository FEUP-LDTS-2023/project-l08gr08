package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Item;

public class ItemViewer implements ElementViewer<Item> {
    @Override
    public void draw (Item item, GUI gui){
        gui.drawItem(item.getPosition());
    }
}
