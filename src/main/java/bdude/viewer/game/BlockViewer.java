package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Block;

public class BlockViewer implements ElementViewer<Block>{
    @Override
    public void draw(Block block, GUI gui){
        gui.drawBlock(block.getPosition());
    }
}
