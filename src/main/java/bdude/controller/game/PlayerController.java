package bdude.controller.game;

import bdude.Game;
import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.game.levels.Level;


public class PlayerController extends GameController {
    public PlayerController(Level level) {
        super(level);
    }

    public void movePlayerLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }
    public void movePlayerRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }
    public void movePlayerUp() {
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }
    public void movePlayerDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }
    private void movePlayer(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
        }
    }
    public void step(Game game, GUI.ACTION action, long time) {
    }
}
