package bdude.model.game.levels;

import java.util.ArrayList;
import java.util.List;
import bdude.model.game.elements.Block;
import bdude.model.game.elements.Enemy;
import bdude.model.game.elements.Player;
import bdude.model.game.elements.Wall;
import bdude.model.game.elements.Item;

public class Level{
    private final int width;
    private final int height;

    private List<Wall> walls = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();

    private Player player = new Player(0, 0);

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Setters //
    public void setPlayer(Player a){
        this.player = a;
    }
    public void setWalls(List<Wall> w){
        this.walls = w;
    }
    public void setBlocks(List<Block> b){
        this.blocks = b;
    }
    public void setItems(List<Item> i){
        this.items = i;
    }
    public void setEnemies(List<Enemy> e){
        this.enemies = e;
    }

    // Getters //
    public Player getPlayer(){
        return player;
    }
}
