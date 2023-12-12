package bdude.controller.game;

import bdude.Game;
import bdude.gui.GUI;
import bdude.model.Position;
<<<<<<< HEAD
import bdude.model.game.elements.Enemy;
=======
import bdude.model.game.elements.Block;
>>>>>>> refs/remotes/origin/master
import bdude.model.game.levels.Level;
import bdude.model.menu.Menu;
import bdude.states.MenuState;

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

    private void handleBlockFall() {
        Position currentPosition = getModel().getPlayer().getPosition();
        if (getModel().getPlayer().getDirection()) {
            currentPosition = currentPosition.getRight();
        }
        else {
            currentPosition = currentPosition.getLeft();

        }
        Position positionBelow = currentPosition.getDown();

        while (getModel().isEmpty(positionBelow)) {
            positionBelow = positionBelow.getDown();
        }
        Position newBlockP = positionBelow.getUp();
        Block newBlock = new Block(newBlockP.getX() - 1, newBlockP.getY());
        newBlock.makeMovable();
        getModel().addBlock(newBlock);
        getModel().getPlayer().setHoldingBlock(false);
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

    public void dropBlockRight(){
        Position currentPosition = getModel().getPlayer().getPosition();
        Position blockNext = currentPosition.getRight();
        if(!getModel().isEmpty(blockNext)) {
            if (getModel().isEmpty(currentPosition.getUp())) {
                Position newBlockP = currentPosition.getUp();
                Block newBlock = new Block(newBlockP.getX(), newBlockP.getY());
                newBlock.makeMovable();
                getModel().addBlock(newBlock);
                getModel().getPlayer().setHoldingBlock(false);
            }
        }

        else if (!getModel().isEmpty(blockNext.getDown())){
            Position newBlockP = currentPosition.getRight();
            Block newBlock = new Block(newBlockP.getX(), newBlockP.getY());
            newBlock.makeMovable();
            getModel().addBlock(newBlock);
            getModel().getPlayer().setHoldingBlock(false);
        }
        else handleBlockFall();
    }

    public void dropBlockLeft(){
        Position currentPosition = getModel().getPlayer().getPosition();
        Position blockNext = currentPosition.getLeft();

        if(!getModel().isEmpty(blockNext)) {
            if (getModel().isEmpty(currentPosition.getUp2())) {
                Position newBlockP = currentPosition.getUp2();

                Block newBlock = new Block(newBlockP.getX(), newBlockP.getY());
                newBlock.makeMovable();

                getModel().addBlock(newBlock);
                getModel().getPlayer().setHoldingBlock(false);
            }
        }
        else if (!getModel().isEmpty(blockNext.getDown())){
            Position newBlockP = currentPosition.getLeft();
            Block newBlock = new Block(newBlockP.getX(), newBlockP.getY());
            newBlock.makeMovable();
            getModel().addBlock(newBlock);
            getModel().getPlayer().setHoldingBlock(false);
        }
        else handleBlockFall();
    }

    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) {
            movePlayerUp();
            getModel().getPlayer().addCounter();
        }
        if (action == GUI.ACTION.LEFT && !getModel().getPlayer().getDirection()) {
            movePlayerLeft();
            getModel().getPlayer().addCounter();
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

        if (action == GUI.ACTION.DOWN) {
            if (!getModel().getPlayer().getHoldingBlock()) {
                if (!getModel().getPlayer().getDirection()) {
                    pickBlockLeft();
                }
                else {
                    pickBlockRight();
                }
            }
            else {
                if (!getModel().getPlayer().getDirection()) {
                    dropBlockLeft();
                }
                else {
                    dropBlockRight();
                }
            }
        }

        if(getModel().playerDead(getModel().getPlayer().getPosition())){
            game.setState(new MenuState(new Menu()));
        }
        if(getModel().isItem(getModel().getPlayer().getPosition())){
            getModel().getPlayer().nextStage();
            getModel().getPlayer().power(true);
        }
        if(getModel().getPlayer().getStage() == 4){
            game.setState(new MenuState(new Menu()));
        }
        for(Enemy e : getModel().getEnemies()){
            e.addCounter();
        }
    }
}
