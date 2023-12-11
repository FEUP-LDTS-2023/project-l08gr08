package bdude.model.game.levels;

import java.util.ArrayList;
import java.util.List;

import bdude.model.Position;
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
    private Player player;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isEmpty(Position position){
        for(Wall wall : walls){
            if(wall.getPosition().equals(position)) return false;
        }
        for(Block block : blocks){
            if(block.getPosition().equals(position)) return false;
        }
        return true;
    }
    public boolean isMovableBlock(Position position) {
        for(Block block : blocks){
            if(block.getPosition().equals(position) && block.isMovable()) return true;
        }
        return false;
    }
    public boolean isItem(Position position) {
        for(Item item : items){
            if(item.getPosition().equals(position)) return true;
        }
        return false;
    }
    public boolean playerDead(Position position) {
        for(Enemy e : enemies){
            if(e.getMoveCounter() == 5 && e.getPosition().getX() == position.getX()){
                return true;
            }
        }
        return false;
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
    public List<Block> getBlocks() {
        return blocks;
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public List<Item> getItems() {
        return items;
    }
    public List<Wall> getWalls() {
        return walls;
    }
}
