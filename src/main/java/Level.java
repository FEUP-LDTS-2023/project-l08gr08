import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int inp;
    private int width = 0;
    private int height = 0;

    public Level (int inp){
        this.inp = inp;
    }
    private List<Wall> walls = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();
    private Player player;

    public void readFile() {
        String file = "";
        if(this.inp == 1){
            file = "../NIVEL1.txt"; // !!! //
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            int coordX = 0;
            int coordY = 0;

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
                        case '2':
                            Item itemB = new Item(coordX,coordY);
                            itemB.switchId(2);
                        case '3':
                            Item itemC = new Item(coordX,coordY);
                            itemC.switchId(3);
                    }
                    coordX++;
                }
                coordY++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#12c0ff")); // later change to an image //
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height),' ');
        player.draw(graphics);
        for (Wall wall : walls) wall.draw(graphics);
        for (Block b : blocks) b.draw(graphics);
    }
}
