package bdude.controller.game;
import bdude.model.Position;
import bdude.model.game.elements.Block;
import bdude.model.game.elements.Player;
import bdude.Game;
import bdude.gui.GUI;
import bdude.model.game.levels.Level;

public class BlockController extends GameController{
    public BlockController(Level level) {
        super(level);
    }

    public void step(Game game, GUI.ACTION action, long time) {
    }
}
