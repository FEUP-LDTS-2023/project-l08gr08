import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WallTests {

    @Test
    public void testDefaultWallPosition() {
        Wall wall = new Wall(0, 0);

        assertEquals(0, wall.getPosition().getX());
        assertEquals(0, wall.getPosition().getY());
    }

}
