import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlockTest {
    @Test
    void testMakeMovable() {
        Block block = new Block(1, 2);
        assertFalse(block.isMovable());
        block.makeMovable();

        assertTrue(block.isMovable());
    }
}
