package bdude.GUI;

import bdude.gui.LanternaGUI;
import bdude.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LanternaGUITest {

    @InjectMocks
    private LanternaGUI gui;

    @Mock
    private Screen screen;

    @Mock
    private TextGraphics tg;

    @BeforeEach
    void setUp() throws IOException {
        this.screen = Mockito.mock(Screen.class);
        this.tg = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);
    }

    @Test
    void drawPlayer() {
        Position position = new Position(1, 1);
        gui.drawPlayer(position);

        verify(tg).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        verify(tg).putString(position.getX(), position.getY() + 3, " >");
    }

    @Test
    void drawPlayer2() {
        Position position = new Position(1, 1);
        gui.drawPlayer2(position);

        verify(tg).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        verify(tg).putString(position.getX(), position.getY() + 3, " <");
    }

    // Add similar tests for other drawing methods...

}
