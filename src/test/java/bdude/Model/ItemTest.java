package bdude.Model;

import bdude.model.game.elements.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void itemId(){
        Item item = new Item(0,0);
        Assertions.assertEquals(1, item.getId());
    }

    @Test
    public void itemSetId(){
        Item item = new Item(0,0);
        item.switchId(2);
        Assertions.assertEquals(2, item.getId());

        item.switchId(3);
        Assertions.assertEquals(3,item.getId());
    }
}
