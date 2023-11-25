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
    // private int stage = 0; // STAGE 0 SHOULD OPEN MENU // TODO LATER // FOR NOW KEEP STAGE AT 1 -> LEVEL
    private int stage = 1;
    private Level level = new Level(1);
    private Screen screen;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(200, 10);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Font myFont = new Font("Monospaced", Font.PLAIN, 45);
        AWTTerminalFontConfiguration myFontConfiguration = AWTTerminalFontConfiguration.newInstance(myFont);
        DefaultTerminalFactory dtf = new DefaultTerminalFactory();
        dtf.setForceAWTOverSwing(true);
        dtf.setTerminalEmulatorFontConfiguration(myFontConfiguration);
        Terminal terminal = dtf.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        level.createWalls();
        level.readFile();
    }

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            level.processKey(key);
            Player player = level.getPlayer();

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
                break;
            }
            else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'r') {
                // restart
            }
            else if (key.getKeyType() == KeyType.EOF) {
                break;
            }
            // !!! EDITAR !!!  ///
            else if (key.getKeyType() == KeyType.ArrowRight && player.getDirection()){
                level.movePlayer(player.moveRight());
            }
            else if (key.getKeyType() == KeyType.ArrowRight && !player.getDirection()){
                level.getPlayer().switchDirection();
            }
            else if (key.getKeyType() == KeyType.ArrowLeft && player.getDirection()){
                level.getPlayer().switchDirection();
            }
            else if (key.getKeyType() == KeyType.ArrowLeft && !player.getDirection()){
                level.movePlayer(player.moveLeft());
            }
        }
    }

    private void draw() throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        // if (stage == 0) menu.draw(graphics) // TODO -> DRAW MENU LATER
        if (stage == 1) { level.draw(graphics); }
        screen.refresh();
    }
}