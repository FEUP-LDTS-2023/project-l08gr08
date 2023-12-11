package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Block;

public class BlockViewer implements ElementViewer<Block>{
    @Override
    public void draw(Block block, GUI gui){
        if(block.isMovable()) {gui.drawMovableBlock(block.getPosition());}
        else gui.drawBlock(block.getPosition());
    }
}
