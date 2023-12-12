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
        Position positionLR = currentPosition.getRight();

        if (!getModel().getPlayer().getDirection()) {
            positionAbove = currentPosition.getUp2();
            positionLR = currentPosition.getLeft();
        }
        if (getModel().isEmpty(positionAbove) && !getModel().isEmpty(positionLR)) {
            getModel().getPlayer().setPosition(positionAbove);
        }
    }

    private void movePlayer(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
        }
    }

    private void handlePlayerFall() {
        Position currentPosition = getModel().getPlayer().getPosition();
        Position positionBelow = currentPosition.getDown();

        while (getModel().isEmpty(positionBelow)) {
            getModel().getPlayer().setPosition(positionBelow);
            positionBelow = positionBelow.getDown();
        }
    }

    public void pickBlockRight(){
        Position blockPos = getModel().getPlayer().getPosition().getRight();

        if (getModel().isMovableBlock(blockPos)){
            getModel().getPlayer().setHoldingBlock(true);
            getModel().deleteBlock(blockPos);
        }
    }

    public void pickBlockLeft(){
        Position blockPos = getModel().getPlayer().getPosition().getLeft();

        if (getModel().isMovableBlock(blockPos)){
            getModel().getPlayer().setHoldingBlock(true);
            getModel().deleteBlock(blockPos);
        }
    }

    public void step(Game game, GUI.ACTION action, long time) {
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
        if (action == GUI.ACTION.DOWN && getModel().getPlayer().getDirection() && !getModel().getPlayer().getHoldingBlock()){
            pickBlockRight();
        }
        if (action == GUI.ACTION.DOWN && !getModel().getPlayer().getDirection() && !getModel().getPlayer().getHoldingBlock()){
            pickBlockLeft();
        }
        if (action == GUI.ACTION.DOWN && getModel().getPlayer().getDirection() && getModel().getPlayer().getHoldingBlock()){
            // dropBlockRight();
        }
        if (action == GUI.ACTION.DOWN && !getModel().getPlayer().getDirection() && getModel().getPlayer().getHoldingBlock()){
            // dropBlockLeft();
        }
    }
}
