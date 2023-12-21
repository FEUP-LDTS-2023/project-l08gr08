package bdude.Controller;

import bdude.controller.game.PlayerController;
import bdude.model.Position;
import bdude.model.game.elements.Block;
import bdude.model.game.elements.Player;
import bdude.model.game.levels.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {
    private PlayerController controller;
    private Player player;
    private Level level;
    private List<Block> blocks;

    @BeforeEach
    void setUp() {
        level = new Level(10,10);
        player = new Player(5,9);
        blocks = new ArrayList<>();

        int y = 10;
        for(int i = 0; i <= 10; i++){
            blocks.add(new Block(i,y));
        }
        level.setBlocks(blocks);
        level.setPlayer(player);

        controller = new PlayerController(level);
    }
    @Test
    void switchDirection() {
        player.switchDirection();
        assertFalse(player.getDirection());
        player.switchDirection();
        assertTrue(player.getDirection());
    }
    @Test
    void moveHeroRightEmpty() {
        controller.movePlayerRight();
        assertEquals(new Position(6, 9), player.getPosition());
    }
    @Test
    void moveHeroLeftEmpty() {
        controller.movePlayerLeft();
        assertEquals(new Position(4, 9), player.getPosition());
    }
    @Test
    void moveHeroRightNotEmpty() {
        blocks.add(new Block(6,9));
        controller.movePlayerRight();
        assertEquals(new Position(5,9), player.getPosition());
    }
    @Test
    void moveHeroLeftNotEmpty() {
        blocks.add(new Block(4,9));
        controller.movePlayerLeft();
        assertEquals(new Position(5,9), player.getPosition());
    }
    @Test
    void moveHeroUpEmptyRight(){
        blocks.add(new Block(6,9));
        controller.movePlayerUp();
        assertEquals(new Position(6,8), player.getPosition());
    }
    @Test
    void moveHeroUpEmptyLeft(){
        blocks.add(new Block(4,9));
        player.switchDirection();
        controller.movePlayerUp();
        assertEquals(new Position(4,8), player.getPosition());
    }
    @Test
    void moveHeroUpNotEmptyRight(){
        blocks.add(new Block(6,9));
        blocks.add(new Block(6,8));
        controller.movePlayerUp();
        assertEquals(new Position(5,9), player.getPosition());
    }
    @Test
    void moveHeroUpNotEmptyFalse(){
        blocks.add(new Block(4,9));
        blocks.add(new Block(4,8));
        controller.movePlayerUp();
        assertEquals(new Position(5,9), player.getPosition());
    }
    @Test
    void pickUpBlockEmptyRight(){
        controller.pickBlockRight();
        assertFalse(player.getHoldingBlock());
    }
    @Test
    void pickUpBlockEmptyLeft(){
        controller.pickBlockLeft();
        assertFalse(player.getHoldingBlock());
    }
    @Test
    void pickUpBlockNotEmptyNotMovableRight(){
        blocks.add(new Block(6,9));
        controller.pickBlockRight();
        assertFalse(player.getHoldingBlock());
    }
    @Test
    void pickUpBlockNotEmptyNotMovableLeft(){
        player.switchDirection();
        blocks.add(new Block(4,9));
        controller.pickBlockLeft();
        assertFalse(player.getHoldingBlock());
    }
    @Test
    void pickUpBlockNotEmptyMovableRight(){
        Block newBlock = new Block(6,9);
        newBlock.makeMovable();
        blocks.add(newBlock);

        controller.pickBlockRight();
        assertTrue(player.getHoldingBlock());
    }
    @Test
    void pickUpBlockNotEmptyMovableLeft(){
        Block newBlock = new Block(4,9);
        player.switchDirection();
        newBlock.makeMovable();
        blocks.add(newBlock);

        controller.pickBlockLeft();
        assertTrue(player.getHoldingBlock());
    }
    @Test
    void dropBlockEmptyRight(){
        player.setHoldingBlock(true);
        controller.dropBlockRight();
        assertFalse(player.getHoldingBlock());

        Position blockPos = new Position(6,9);
        boolean result = false;
        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).getPosition().equals(blockPos)) result = true;
        }

        assertTrue(result);
    }
    @Test
    void dropBlockEmptyLeft(){
        player.setHoldingBlock(true);
        controller.dropBlockLeft();
        assertFalse(player.getHoldingBlock());

        Position blockPos = new Position(4,9);
        boolean result = false;
        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).getPosition().equals(blockPos)) result = true;
        }

        assertTrue(result);
    }
    @Test
    void dropBlockEmpty2Right(){
        Block newBlock = new Block(6,9);
        blocks.add(newBlock);

        player.setHoldingBlock(true);
        controller.dropBlockRight();

        assertFalse(player.getHoldingBlock());

        Position blockPos = new Position(6,8);
        boolean result = false;

        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).getPosition().equals(blockPos)) result = true;
        }
        assertTrue(result);
    }
    @Test
    void dropBlockEmpty2Left(){
        Block newBlock = new Block(4,9);
        blocks.add(newBlock);

        player.setHoldingBlock(true);
        controller.dropBlockLeft();

        assertFalse(player.getHoldingBlock());

        Position blockPos = new Position(4,8);
        boolean result = false;

        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).getPosition().equals(blockPos)) result = true;
        }
        assertTrue(result);
    }
}
