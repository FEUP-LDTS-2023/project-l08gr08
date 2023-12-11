package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Item;

public class ItemViewer implements ElementViewer<Item> {
    @Override
    public void draw (Item item, GUI gui){
        if (item.getId() == 1) {gui.drawItem1(item.getPosition());}
        if (item.getId() == 2) {gui.drawItem2(item.getPosition());}
        if (item.getId() == 3) {gui.drawItem3(item.getPosition());}
    }
}
