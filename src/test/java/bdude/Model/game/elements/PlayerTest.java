package bdude.Model.game.elements;

import bdude.model.game.elements.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testStageEvo () {
        Player player = new Player(0,0);
        player.nextStage();

        Assertions.assertEquals(2,player.getStage());

        player.nextStage();

        Assertions.assertEquals(3,player.getStage());
    }
    @Test
    public void testHoldingBlock1 (){
        Player player = new Player(3232,2323);
        Assertions.assertFalse(player.getHoldingBlock());
    }
    @Test
    public void testHoldingBlock2 (){
        Player player = new Player(30,20);
        player.setHoldingBlock(true);

        Assertions.assertTrue(player.getHoldingBlock());

        player.setHoldingBlock(false);
        Assertions.assertFalse(player.getHoldingBlock());
    }
    @Test public void testPower () {
        Player player = new Player(20,10);

        Assertions.assertFalse(player.getPower());

        player.power(true);
        Assertions.assertTrue(player.getPower());
        Assertions.assertFalse(player.getPowerActive());

        player.setPowerActive();
        Assertions.assertTrue(player.getPowerActive());
    }
    @Test
    public void testDirection(){
        Player player = new Player(30,28);

        Assertions.assertTrue(player.getDirection());

        player.switchDirection();
        Assertions.assertFalse(player.getDirection());

        player.switchDirection();
        Assertions.assertTrue(player.getDirection());
    }
    @Test
    public void testLives(){
        Player player = new Player(50,50);
        Assertions.assertEquals(3,player.getLives());

        player.setLives(2);
        Assertions.assertEquals(2,player.getLives());

        player.setLives(1);
        Assertions.assertEquals(1,player.getLives());
    }
}
