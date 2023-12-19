package bdude.GUI;

import bdude.gui.LanternaGUI;
import bdude.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;


public class LanternaGUITest {

    @InjectMocks
    private LanternaGUI gui;

    @Mock
    private Screen screen;

    @Mock
    private TextGraphics tg;

    @BeforeEach
    void setUp() throws IOException {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
    }

    @Test
    void drawPlayer() throws IOException {
        Position position = new Position(1, 1);
        gui.drawPlayer(position);

        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg).putString(position.getX(), position.getY() + 3, " >");
    }

    @Test
    void drawPlayer2() {
        Position position = new Position(1, 1);
        gui.drawPlayer2(position);

        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg).putString(position.getX(), position.getY() + 3, " <");
    }

    @Test
    void drawPlayerPower() {
        Position position = new Position(1, 1);
        gui.drawPlayerPower(position);

        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg).putString(position.getX(), position.getY() + 3, "»");
    }

    @Test
    void drawPlayerPower2() {
        Position position = new Position(1, 1);
        gui.drawPlayerPower2(position);

        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg).putString(position.getX(), position.getY() + 3, "«");
    }

    @Test
    void drawBlock() {
        Position position = new Position(1, 1);
        gui.drawBlock(position);

        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        Mockito.verify(tg).putString(position.getX(), position.getY() + 3, "B");
    }

    @Test
    void drawMovableBlock() {
        Position position = new Position(1, 1);
        gui.drawMovableBlock(position);

        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#E6E6FA"));
        Mockito.verify(tg).putString(position.getX(), position.getY() + 3, "M");
    }

    @Test
    void drawHoldingBlock() {
        Position position = new Position(1, 1);
        gui.drawHoldingBlock(position);

        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#E6E6FA"));
        Mockito.verify(tg).putString(position.getX(), position.getY() + 3, "M");
    }
}
