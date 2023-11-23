import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


import java.awt.*;
import java.io.IOException;

public class Game {
    private int stage = 1;
    private Level level = new Level(1);
    private Screen screen;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(200, 50);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Font myFont = new Font("Monospaced", Font.PLAIN, 50); // Change the number 20 to your desired font size
        AWTTerminalFontConfiguration myFontConfiguration = AWTTerminalFontConfiguration.newInstance(myFont);
        // Use myFontConfiguration when creating your terminal
        // Create a default terminal (will use Swing on desktop)
        // Use myFontConfiguration when creating your terminal
        DefaultTerminalFactory dtf = new DefaultTerminalFactory();
        dtf.setForceAWTOverSwing(true);
        dtf.setTerminalEmulatorFontConfiguration(myFontConfiguration);
        Terminal terminal = dtf.createTerminal();


        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        level.readFile();
    }

    private void draw() throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        level.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException {
        while (true){
            draw();
            KeyStroke key = screen.readInput();
            level.processKey(key);

        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
            break;
        }
        else if (key.getKeyType() == KeyType.EOF) {
                break;
            }
        }
    }
}