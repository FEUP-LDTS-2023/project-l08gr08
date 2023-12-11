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
        if(getModel().getPlayer().getDirection()) movePlayer(getModel().getPlayer().getPosition().getUp());
        else movePlayer(getModel().getPlayer().getPosition().getUp().getUp2());
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
        if (action == GUI.ACTION.DOWN) {
            movePlayerDown();
        }
        if (action == GUI.ACTION.UP) {
            movePlayerUp();
        }
        if (action == GUI.ACTION.LEFT && !getModel().getPlayer().getDirection()) {
            movePlayerLeft();
        }
        if (action == GUI.ACTION.RIGHT && getModel().getPlayer().getDirection()) {
            movePlayerRight();
        }
        if (action == GUI.ACTION.LEFT && getModel().getPlayer().getDirection()) {
            getModel().getPlayer().switchDirection();
        }
        if (action == GUI.ACTION.RIGHT && !getModel().getPlayer().getDirection()) {
            getModel().getPlayer().switchDirection();
        }
        if (action == GUI.ACTION.POWER && getModel().getPlayer().getPower() && !getModel().getPlayer().getPowerActive()){
            getModel().getPlayer().setPowerActive();
        }
    }
}
