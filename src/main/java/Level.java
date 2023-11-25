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
    int centerX = 21;
    int centerY = 4;

    int TerminalFirstX = 30;
    int TerminalFirstY = 11;

    public Level (int inp){
        this.inp = inp;
    }
    private List<Wall> walls = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();

    private Player player = new Player(0,0);

    public Player getPlayer(){
        return player;
    }

    public void createWalls(){ // CREATE WALLS AROUND LEVEL
        for(int i = 0; i < 31; i++){
            walls.add(new Wall(centerX - 1 + i, centerY - 1));
            walls.add(new Wall(centerX - 1 + i, centerY + 11));
        }
        for(int j = 0; j < 13; j++){
            walls.add(new Wall(centerX - 1, j + centerY - 1));
            walls.add(new Wall(centerX + 30, centerY + j - 1));
        }
    }

    public void movePlayer(Position position) {
        player.setPosition(position);
    }

    public void readFile() { // read files to create levels
        String file = "";
        if (this.inp == 1) {
            file = "src/main/java/NIVEL1.txt";
        } else if (this.inp == 2) {
            file = "src/main/java/NIVEL2.txt";
        } else if (this.inp == 3) {
            file = "src/main/java/NIVEL3.txt";
        } else if (this.inp == 4) {
            file = "src/main/java/NIVEL4.txt";
        } else if (this.inp == 5) {
            file = "src/main/java/NIVEL5.txt";
        }
        int temp = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            temp = line.length();
            int coordX;
            int coordY = 0;

            while ((line = reader.readLine()) != null && coordY < 13) {
                coordX = 0;

                while (coordX < line.length()) {
                    switch (line.charAt(coordX)) {
                        case 'B':
                            blocks.add(new Block(coordX,coordY));
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
                            Item itemA = new Item(coordX, coordY);
                            items.add(itemA);
                            break;
                        case '2':
                            Item itemB = new Item(coordX, coordY);
                            itemB.switchId(2);
                            items.add(itemB);
                            break;
                        case '3':
                            Item itemC = new Item(coordX, coordY);
                            itemC.switchId(3);
                            items.add(itemC);
                            break;
                        case 'E':
                            Enemy enemy = new Enemy(coordX, coordY);
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
        for (Block b : blocks) { b.setPlayerX(player.getPosition().getX());}
        for (Item i : items) {i.setPlayerX(player.getPosition().getX());}
        for (Enemy e : enemies){e.setPlayerX(player.getPosition().getX());}
    } // DONE

    public void draw(TextGraphics graphics) {
        // TEXT APPEARING ON TOP OF LEVEL
        graphics.putString(new TerminalPosition(centerX + 0, 1), "B");
        graphics.putString(new TerminalPosition(centerX + 1, 1), "L");
        graphics.putString(new TerminalPosition(centerX + 2, 1), "O");
        graphics.putString(new TerminalPosition(centerX + 3, 1), "C");
        graphics.putString(new TerminalPosition(centerX + 4, 1), "K");
        graphics.putString(new TerminalPosition(centerX + 5, 1), "-");
        graphics.putString(new TerminalPosition(centerX + 6, 1), "D");
        graphics.putString(new TerminalPosition(centerX + 7, 1), "U");
        graphics.putString(new TerminalPosition(centerX + 8, 1), "D");
        graphics.putString(new TerminalPosition(centerX + 9, 1), "E");
        graphics.putString(new TerminalPosition(centerX + 10, 1), " ");
        graphics.putString(new TerminalPosition(centerX + 11, 1), "L");
        graphics.putString(new TerminalPosition(centerX + 12, 1), "E");
        graphics.putString(new TerminalPosition(centerX + 13, 1), "V");
        graphics.putString(new TerminalPosition(centerX + 14, 1), "E");
        graphics.putString(new TerminalPosition(centerX + 15, 1), "L");
        graphics.putString(new TerminalPosition(centerX + 16, 1), " ");
        if(inp == 1){ graphics.putString(new TerminalPosition(centerX + 17, 1), "1");}
        else if(inp == 2){ graphics.putString(new TerminalPosition(centerX + 17, 1), "2");}
        else if(inp == 3){ graphics.putString(new TerminalPosition(centerX + 17, 1), "3");}
        else if(inp == 4){ graphics.putString(new TerminalPosition(centerX + 17, 1), "4");}
        else if(inp == 5){ graphics.putString(new TerminalPosition(centerX + 17, 1), "5");}

        graphics.setBackgroundColor(TextColor.Factory.fromString("#8cd3ff")); // TODO change background to  a beautiful skye pixel art :]
        graphics.fillRectangle(new TerminalPosition(centerX,centerY), new TerminalSize(TerminalFirstX, TerminalFirstY),' ');
        player.draw(graphics);
        for (Block b : blocks) b.draw(graphics);
        for (Item i : items) i.draw(graphics);
        for (Enemy e : enemies) e.draw(graphics);
        for (Wall wall : walls) wall.draw(graphics);
    }
    public void processKey(KeyStroke key) {
        System.out.println(key);
        int x = player.getPosition().getX();
        for (Block b : blocks) {
            b.setPlayerX(x);
        }
        for (Item i : items) {
            i.setPlayerX(x);
        }
        for (Enemy e : enemies){
            e.setPlayerX(x);
        }
    }
}
