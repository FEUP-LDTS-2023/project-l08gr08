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

    public void moveBlock() {
        Position currentPosition = getModel().getPlayer().getPosition();
        Position nextPosition = currentPosition.getRight();
        if (!getModel().getPlayer().getDirection()) {
            nextPosition = currentPosition.getLeft();
        }
        if (getModel().isMovableBlock(nextPosition)) {
            getModel().getPlayer().setHoldingBlock(true);
        }
    }

    /*public void movePlayerUp() {
        Position currentPosition = getModel().getPlayer().getPosition();
        Position positionAbove = currentPosition.getUp();
        Position positionLR = currentPosition.getRight();

        if (!getModel().getPlayer().getDirection()) {
            positionAbove = currentPosition.getUp2();
            positionLR = currentPosition.getLeft();
        }

        if (getModel().isEmpty(positionAbove) && !getModel().isEmpty(positionLR)) {
            getModel().getPlayer().setPosition(positionAbove);
        }
    }*/
    public void placeBlock() {

    }

    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.DOWN) {
            if(!getModel().getPlayer().getHoldingBlock()) {
                moveBlock();
            }
            else {
                placeBlock();
            }
        }
    }
}
