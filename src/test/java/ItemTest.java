import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testDefaultItem() {
        Item item = new Item(0, 0);

        assertEquals(1, item.getId());
    }

    @Test
    public void testSwitchId() {
        Item item = new Item(0, 0);
        item.switchId(2);

        assertEquals(2, item.getId());
    }

}
