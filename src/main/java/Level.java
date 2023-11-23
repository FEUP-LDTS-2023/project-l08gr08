import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private int inp;
    private int width = 0;
    private int height = 0;

    public Level (int inp){
        this.inp = inp;
    }
    private List<Wall> walls = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private Player player = new Player(0,0);

    public void readFile() {
        String file = "";
        if(this.inp == 1){
            file = "src/main/java/NIVEL1.txt"; // !!! //
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            int coordX;
            int coordY = 0;

            int centerX = 32;
            int centerY = 32;

            while ((line = reader.readLine()) != null && coordY < 13) {
                coordX = 0;

                while (coordX < line.length()) {
                    switch (line.charAt(coordX)) {
                        case '#':
                            walls.add(new Wall(coordX, coordY));
                            break;
                        case 'B':
                            blocks.add(new Block(coordX, coordY));
                            break;
                        case 'M':
                            Block mBlock = new Block(coordX, coordY);
                            mBlock.makeMovable();
                            blocks.add(mBlock);
                            break;
                        case '>':
                            player = new Player(coordX, coordY);
                            break;
                        case '<':
                            player = new Player(coordX, coordY);
                            player.switchDirection();
                            break;
                        case '1':
                            Item itemA = new Item(coordX,coordY);
                            items.add(itemA);
                            break;
                        case '2':
                            Item itemB = new Item(coordX,coordY);
                            itemB.switchId(2);
                            items.add(itemB);
                            break;
                        case '3':
                            Item itemC = new Item(coordX,coordY);
                            itemC.switchId(3);
                            items.add(itemC);
                            break;
                        case 'E':
                            Enemy enemy = new Enemy(coordX,coordY);
                            enemies.add(enemy);
                            break;
                    }
                    coordX++;
                }
                coordY++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(TextGraphics graphics) /*throws IOException*/ {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#8cd3ff"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(43, 13),' ');
        player.draw(graphics);
        for (Wall wall : walls) wall.draw(graphics);
        for (Block b : blocks) b.draw(graphics);
        for (Item i : items) i.draw(graphics);
        for (Enemy e : enemies) e.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
    }
}
