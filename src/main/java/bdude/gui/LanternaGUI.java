package bdude.gui;

import bdude.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'q' || keyStroke.getCharacter() == 'Q')) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'p' || keyStroke.getCharacter() == 'P')) return ACTION.POWER;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'r' || keyStroke.getCharacter() == 'R')) return ACTION.RESTART;

        return ACTION.NONE;
    }

    int desvio = 2;
    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '>', "#FFD700");
    }
    @Override
    public void drawPlayer2(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '<', "#FFD700");
    }
    @Override
    public void drawPlayerPower(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '»', "#FFD700");
    }
    @Override
    public void drawPlayerPower2(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '«', "#FFD700");
    }
    @Override
    public void drawBlock(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, 'B', "#3333FF");
    }
    public void drawMovableBlock(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, 'M', "#E6E6FA");
    }
    @Override
    public void drawHoldingBlock(Position position){
        drawCharacter(position.getX()-1, position.getY() + desvio, 'M', "#E6E6FA");
    }
    @Override
    public void drawEnemy(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, 'E', "#CC0000");
    }
    @Override
    public void drawEnemyRay(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '*', "#de34eb");
    }
    @Override
    public void drawItem1(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '1', "#00FF00");
    }
    @Override
    public void drawItem2(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '2', "#00FF00");
    }
    @Override
    public void drawItem3(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio, '3', "#00FF00");
    }
    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY() + desvio , '#', "#FFFFFF");
    }
    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }
    public void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + desvio, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }
    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }
    @Override
    public void close() throws IOException {
        screen.close();
    }
}
