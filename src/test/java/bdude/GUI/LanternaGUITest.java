package bdude.GUI;

import static org.mockito.Mockito.*;

import bdude.gui.LanternaGUI;
import bdude.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LanternaGUITest {

    private LanternaGUI lanternaGUI;
    private Screen mockScreen;
    private TextGraphics mockTextGraphics;

    @BeforeEach
    void setUp() throws IOException {
        mockScreen = mock(Screen.class);
        mockTextGraphics = mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);
        lanternaGUI = new LanternaGUI(mockScreen);
    }

    @AfterEach
    void tearDown() throws IOException {
        lanternaGUI.close();
    }

    @Test
    void drawPlayerTest() throws IOException {
        // Arrange
        Position position = new Position(1, 4);

        // Act
        lanternaGUI.drawPlayer(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        verify(mockTextGraphics).putString(eq(1), eq(8), eq(">"));

    }

    @Test
    void drawPlayer2Test() throws IOException {
        // Arrange
        Position position = new Position(1, 5);

        // Act
        lanternaGUI.drawPlayer2(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        verify(mockTextGraphics).putString(eq(1), eq(9), eq("<"));

    }

    @Test
    void drawPlayerPowerTest() throws IOException {
        // Arrange
        Position position = new Position(1, 2);

        // Act
        lanternaGUI.drawPlayerPower(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        verify(mockTextGraphics).putString(eq(1), eq(6), eq("»"));

    }

    @Test
    void drawPlayerPower2Test() throws IOException {
        // Arrange
        Position position = new Position(1, 2);

        // Act
        lanternaGUI.drawPlayerPower2(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        verify(mockTextGraphics).putString(eq(1), eq(6), eq("«"));

    }

    @Test
    void drawBlockTest() throws IOException {
        // Arrange
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawBlock(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        verify(mockTextGraphics).putString(eq(1), eq(14), eq("B"));

    }

    @Test
    void drawMovableBlockTest() throws IOException {
        // Arrange
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawMovableBlock(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#E6E6FA"));
        verify(mockTextGraphics).putString(eq(1), eq(14), eq("M"));

    }

    @Test
    void drawHoldingBlockTest() throws IOException {
        // Arrange
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawHoldingBlock(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#E6E6FA"));
        verify(mockTextGraphics).putString(eq(0), eq(14), eq("M"));

    }

    @Test
    void drawEnemyTest() throws IOException {
        // Arrange
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawEnemy(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        verify(mockTextGraphics).putString(eq(1), eq(14), eq("E"));

    }

    @Test
    void drawItem1Test() throws IOException {
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawItem1(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        verify(mockTextGraphics).putString(eq(1), eq(14), eq("1"));

    }
    @Test
    void drawItem2Test() throws IOException {
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawItem2(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        verify(mockTextGraphics).putString(eq(1), eq(14), eq("2"));

    }
    @Test
    void drawItem3Test() throws IOException{
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawItem3(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        verify(mockTextGraphics).putString(eq(1), eq(14), eq("3"));

    }
    @Test
    void drawWallTest() throws IOException{
        Position position = new Position(1, 10);

        // Act
        lanternaGUI.drawWall(position);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        verify(mockTextGraphics).putString(eq(1), eq(14), eq("#"));

    }

    @Test
    void drawTextTest() throws IOException {
        // Arrange
        Position position = new Position(1, 4);
        String text = "Hello, Bdude!";
        String color = "#FFFFFF";

        // Act
        lanternaGUI.drawText(position, text, color);

        // Assert
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString(color));
        verify(mockTextGraphics).putString(eq(1), eq(4), eq(text));
    }

    @Test
    void refreshTest() throws IOException {
        // Arrange
        lanternaGUI.drawText(new Position(1, 4), "Hello, Bdude!", "#FFFFFF");

        // Act
        lanternaGUI.refresh();

        // Assert
        verify(mockScreen).refresh();
    }
}
