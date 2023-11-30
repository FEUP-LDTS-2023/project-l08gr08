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
    private int stage = 0; // STAGE 0 SHOULD OPEN MENU // TODO LATER // FOR NOW KEEP STAGE AT 1 -> LEVEL
    private LevelA levelA = new LevelA(1);
    private LevelB levelB = new LevelB(2);
    // private LevelC levelC = new LevelC(3);

    private Screen screen;

    public void setStage(int s){
        this.stage = s;
    }

    public void setLevelA(){
        levelA = new LevelA(1);
    }

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
    }

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();

            if(stage == 0){ // WHEN MENU IS OPEN
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == '1') {
                    setStage(1);
                }
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == '2') {
                    setStage(2);
                }
                if (key.getKeyType() == KeyType.Character && (key.getCharacter() == '3' || key.getCharacter() == 'q' || key.getCharacter() == 'Q')) {
                    screen.close();
                    break;
                }
            }

            if(stage == 1) {
                levelA.processKey(key);
                levelA.createWalls();
                levelA.readFile();

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                    screen.close();
                    break;
                }
                else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'r') {
                    // restart level;
                }
                else if (key.getKeyType() == KeyType.EOF) {
                    break;
                }
                else if (key.getKeyType() == KeyType.ArrowRight && levelA.getPlayer().getDirection()) {
                    levelA.getPlayer().setPosition(levelA.movePlayerRight());
                }
                else if (key.getKeyType() == KeyType.ArrowRight && !levelA.getPlayer().getDirection()) {
                    levelA.getPlayer().switchDirection();
                }
                else if (key.getKeyType() == KeyType.ArrowLeft && levelA.getPlayer().getDirection()) {
                    levelA.getPlayer().switchDirection();
                }
                else if (key.getKeyType() == KeyType.ArrowLeft && !levelA.getPlayer().getDirection()) {
                    levelA.getPlayer().setPosition(levelA.movePlayerLeft());
                }
            }
        }
    }
    private void draw() throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        // if (stage == 0) menu.draw(graphics) // TODO -> DRAW MENU LATER
        if (stage == 1) {levelA.draw(graphics);}
        screen.refresh();
    }
}