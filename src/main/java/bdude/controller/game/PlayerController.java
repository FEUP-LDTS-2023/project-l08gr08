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
        handlePlayerFall();
    }
    public void movePlayerRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
        handlePlayerFall();
    }
    public void movePlayerUp() {
        Position currentPosition = getModel().getPlayer().getPosition();
        Position positionAbove = currentPosition.getUp();
        Position positionNext = getModel().getPlayer().getDirection() ? currentPosition.getRight() : currentPosition.getLeft();

        // Move the player up only if the position above is empty and the next position has support
        if (getModel().isEmpty(positionAbove) && !getModel().isEmpty(positionNext)) {
            getModel().getPlayer().setPosition(positionAbove);
        }
    }
    public void movePlayerDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }
    private void movePlayer(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
        }

    }
    private void handlePlayerFall() {
        Position currentPosition = getModel().getPlayer().getPosition();
        Position positionBelow = currentPosition.getDown();

        // Keep falling as long as there are empty positions below
        while (getModel().isEmpty(positionBelow)) {
            getModel().getPlayer().setPosition(positionBelow);
            positionBelow = positionBelow.getDown();
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
