package bdude.model.game.levels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import bdude.model.game.elements.Block;
import bdude.model.game.elements.Enemy;
import bdude.model.game.elements.Player;
import bdude.model.game.elements.Wall;
import bdude.model.game.elements.Item;
import bdude.model.Position;
import static java.lang.Integer.MAX_VALUE;

 public class Level {
    private int inp;
    int bestMoves = MAX_VALUE;
    int moveCounter = 0;

    int centerX = 21;
    int centerY = 4;

    int TerminalFirstX = 30;
    int TerminalFirstY = 11;

    public Level(int inp) {
        this.inp = inp;
    }

    private List<Wall> walls = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();

    private Player player = new Player(0, 0);

    public Player getPlayer() {
        return player;
    }

    public void createWalls() { // CREATE WALLS AROUND LEVEL
        for (int i = 0; i < 31; i++) {
            walls.add(new Wall(centerX - 1 + i, centerY - 1));
            walls.add(new Wall(centerX - 1 + i, centerY + 11));
        }
        for (int j = 0; j < 13; j++) {
            walls.add(new Wall(centerX - 1, j + centerY - 1));
            walls.add(new Wall(centerX + 30, centerY + j - 1));
        }
    }

    public Position movePlayerRight() {
        Position position = player.getPosition();
        for (Block b : blocks) {
            if (b.getPosition().getX() - 1 == player.getPosition().getX() && b.getPosition().getY() <= player.getPosition().getY()) {
                int newX = b.getPosition().getX();
                int newY = b.getPosition().getY();
                position = new Position(newX, newY);
                moveCounter++;
            }
        }
        return position;
    }

    public Position movePlayerLeft() {
        Position position = player.getPosition();
        for (Block b : blocks) {
            if (b.getPosition().getX() + 1 == player.getPosition().getX() && b.getPosition().getY() <= player.getPosition().getY()) {
                int newX = b.getPosition().getX();
                int newY = b.getPosition().getY();
                position = new Position(newX, newY);
                moveCounter++;
            }
        }
        return position;
    }

    int levelLength;

    public void readFile() { // read files to create levels
        String file = "";
        if (this.inp == 1) {
            file = "src/resources/levels/NIVEL1.txt";
        } else if (this.inp == 2) {
            file = "src/resources/levels/NIVEL2.txt";
        } else if (this.inp == 3) {
            file = "src/resources/levels/NIVEL3.txt";
        } else if (this.inp == 4) {
            file = "src/resources/levels/NIVEL4.txt";
        } else if (this.inp == 5) {
            file = "src/resources/levels/NIVEL5.txt";
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            levelLength = line.length();
            int coordX;
            int coordY = 0;

            while ((line = reader.readLine()) != null && coordY < 13) {
                coordX = 0;

                while (coordX < line.length()) {
                    switch (line.charAt(coordX)) {
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
    }
}
