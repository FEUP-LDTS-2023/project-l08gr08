package bdude.controller.game;

import bdude.Game;
import bdude.gui.GUI;
import bdude.model.game.levels.Level;

public class BlockController extends GameController{
    public BlockController(Level level) {
        super(level);
    }

    public void moveBlock() {
        if (getModel().getBlocks().isEmpty()) {

        }
    }

    public void step(Game game, GUI.ACTION action, long time) {
    }
}
