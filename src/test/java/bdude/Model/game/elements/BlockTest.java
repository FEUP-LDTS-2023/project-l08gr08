package bdude.Model.game.elements;

import bdude.model.game.elements.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlockTest {
    @Test
    public void checkMovable(){
        Block block = new Block(0,0);
        block.makeMovable();

        boolean expectedResult = true;

        Assertions.assertEquals(block.isMovable(), expectedResult);
    }
    @Test
    public void checkNotMovable(){
        Block block = new Block(30,10);
        boolean expectedResult = false;

        Assertions.assertEquals(block.isMovable(), expectedResult);
    }
}
