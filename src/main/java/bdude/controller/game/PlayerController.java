package bdude.controller.game;

import bdude.Game;
import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.game.elements.Block;
import bdude.model.game.levels.Level;
import bdude.model.game.levels.LevelReadBuilder;
import bdude.model.menu.LevelCleared;
import bdude.model.menu.LevelNotCleared;
import bdude.model.menu.Menu;
import bdude.states.GameState;
import bdude.states.LevelClearedState;
import bdude.states.LevelNotClearedState;
import bdude.states.MenuState;

import java.io.IOException;

public class PlayerController extends GameController {
    public PlayerController(Level level) {
        super(level);
    }
    public void movePlayerLeft() {
        if (getModel().getPlayer().getHoldingBlock()) {
            if (getModel().isEmpty(getModel().getPlayer().getPosition().getUp2())) {
                movePlayer(getModel().getPlayer().getPosition().getLeft());
                handlePlayerFall();
            }
        }
        else {
            movePlayer(getModel().getPlayer().getPosition().getLeft());
            handlePlayerFall();
        }

    }

    public void movePlayerRight() {
        if (getModel().getPlayer().getHoldingBlock()) {
            if (getModel().isEmpty(getModel().getPlayer().getPosition().getUp())) {
                movePlayer(getModel().getPlayer().getPosition().getRight());
                handlePlayerFall();
            }
        }
        else {
            movePlayer(getModel().getPlayer().getPosition().getRight());
            handlePlayerFall();
        }

    }

    public void movePlayerUp() {
        if (getModel().getPlayer().getHoldingBlock()) {
            if (getModel().isEmpty(new Position(getModel().getPlayer().getPosition().getUp().getX(), getModel().getPlayer().getPosition().getUp().getY()-1))) {
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
        }
        else {
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

        if (getModel().isMovableBlock(blockPos) && getModel().isEmpty(new Position(blockPos.getX(),blockPos.getY()-1))){
            getModel().getPlayer().setHoldingBlock(true);
            getModel().deleteBlock(blockPos);
        }
    }

    public void pickBlockLeft(){
        Position blockPos = getModel().getPlayer().getPosition().getLeft();

        if (getModel().isMovableBlock(blockPos) && getModel().isEmpty(new Position(blockPos.getX(),blockPos.getY()-1))){
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

    public void pickItem(Position position){
        getModel().getPlayer().nextStage();
        getModel().deleteItem(position);
        getModel().getPlayer().power(true);
    }

    public void breakBlock(Position position){
        if(getModel().getPlayer().getPowerActive()) {
            if (getModel().getPlayer().getDirection()) {
                getModel().deleteBlock(position.getRight());
            } else {
                getModel().deleteBlock(position.getLeft());
            }
        }
        getModel().getPlayer().power(false);
        getModel().getPlayer().setPowerInactive();
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().changeEnemies();

        if (action == GUI.ACTION.UP && !getModel().isEmpty(new Position(getModel().getPlayer().getPosition().getX(), getModel().getPlayer().getPosition().getY()+1)) && getModel().isEmpty(new Position(getModel().getPlayer().getPosition().getX(), getModel().getPlayer().getPosition().getY() - 1))) {
            movePlayerUp();
            getModel().getPlayer().addCounter();
            getModel().incrementEnemyCounter();
        }
        if (action == GUI.ACTION.LEFT && !getModel().getPlayer().getDirection()) {
            movePlayerLeft();
            getModel().getPlayer().addCounter();
            getModel().incrementEnemyCounter();
        }
        if (action == GUI.ACTION.RIGHT && getModel().getPlayer().getDirection()) {
            movePlayerRight();
            getModel().getPlayer().addCounter();
            getModel().incrementEnemyCounter();
        }

        if (action == GUI.ACTION.LEFT && getModel().getPlayer().getDirection()) {
            getModel().getPlayer().switchDirection();
            getModel().getPlayer().addCounter();
            getModel().incrementEnemyCounter();
        }

        if (action == GUI.ACTION.RIGHT && !getModel().getPlayer().getDirection()) {
            getModel().getPlayer().switchDirection();
            getModel().getPlayer().addCounter();
            getModel().incrementEnemyCounter();
        }

        if (action == GUI.ACTION.POWER && getModel().getPlayer().getPower() && !getModel().getPlayer().getPowerActive()){
            getModel().getPlayer().setPowerActive();
        }

        if (action == GUI.ACTION.DOWN) {
            if (!getModel().getPlayer().getHoldingBlock()) {
                if (!getModel().getPlayer().getDirection()) pickBlockLeft();
                else pickBlockRight();
            }
            else {
                if (!getModel().getPlayer().getDirection()) dropBlockLeft();
                else dropBlockRight();
            }
            getModel().getPlayer().addCounter();
            getModel().incrementEnemyCounter();
        }

        if (action == GUI.ACTION.RESTART){
            int lives = getModel().getPlayer().getLives();
            if(lives == 1){  game.setState(new LevelNotClearedState(new LevelNotCleared(getModel().getInp())));}
            else game.setState(new GameState(new LevelReadBuilder(getModel().getInp(), lives - 1).createLevel()));
        }

        if (action == GUI.ACTION.SELECT && getModel().getPlayer().getPowerActive()){
            breakBlock(getModel().getPlayer().getPosition());
        }
        if(getModel().isItem(getModel().getPlayer().getPosition())){
            pickItem(getModel().getPlayer().getPosition());
        }
        if(getModel().getItems().isEmpty()) {
            game.setState(new MenuState(new Menu()));
            game.setState(new LevelClearedState(new LevelCleared(getModel().getInp())));
        }
        if(getModel().playerDead(getModel().getPlayer().getPosition())){
            int lives = getModel().getPlayer().getLives();
            if(lives == 1){  game.setState(new LevelNotClearedState(new LevelNotCleared(getModel().getInp())));}
            else game.setState(new GameState(new LevelReadBuilder(getModel().getInp(), lives - 1).createLevel()));
        }
    }
}
