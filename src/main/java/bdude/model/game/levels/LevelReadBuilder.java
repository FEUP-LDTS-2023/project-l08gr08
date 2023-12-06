package bdude.model.game.levels;

import bdude.model.game.elements.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelReadBuilder extends LevelBuilder {
    private final int level;
    private final List<String> lines;

    public LevelReadBuilder(int level) throws IOException {
        this.level = level;

        URL resource = null;
        if (level == 1) {resource = LevelReadBuilder.class.getResource("src/resources/levels/NIVEL1.txt");}
        else if (level == 2) {resource = LevelReadBuilder.class.getResource("src/resources/levels/NIVEL2.txt");}
        else if (level == 3) {resource = LevelReadBuilder.class.getResource("src/resources/levels/NIVEL3.txt");}
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        this.lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }
    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }
    @Override
    protected int getHeight() {
        return lines.size();
    }
    @Override
    protected List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') {
                    blocks.add(new Block(x, y));
                }
                else if (line.charAt(x) == 'M') {
                    Block temp = new Block(x,y);
                    temp.makeMovable();
                    blocks.add(temp);
                }
        }
        return blocks;
    }
    @Override
    protected List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'E') enemies.add(new Enemy(x, y));
        }
        return enemies;
    }
    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }
        return walls;
    }
    @Override
    protected List<Item> createItems() {
        List<Item> items = new ArrayList<>();

        for(int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);

            for(int x = 0; x < line.length(); x++){
                if (line.charAt(x) == '1') {
                    items.add(new Item(x,y));
                }
                else if (line.charAt(x) == '2') {
                    Item temp = new Item(x,y);
                    temp.switchId(2);
                    items.add(temp);
                }
                else if (line.charAt(x) == '3') {
                    Item temp = new Item(x,y);
                    temp.switchId(3);
                    items.add(temp);
                }
            }
        }
        return items;
    }
    @Override
    protected Player createPlayer() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '>') {
                    return new Player(x, y);
                }
                else if (line.charAt(x) == '<') {
                    Player temp = new Player(x,y);
                    temp.switchDirection();
                    return temp;
                }
            }
        }
        return null;
    }
}