package bdude.model.game.levels;

import bdude.model.game.elements.*;
import java.util.List;

public abstract class LevelBuilder {
    public Level createLevel(){
        Level level = new Level(getWidth(), getHeight());

        level.setPlayer(createPlayer());
        level.setBlocks(createBlocks());
        level.setEnemies(createEnemies());
        level.setItems(createItems());
        level.setWalls(createWalls());
        level.setInp(getInp());

        return level;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract int getInp();

    protected abstract List<Block> createBlocks();
    protected abstract List<Enemy> createEnemies();
    protected abstract List<Wall> createWalls();
    protected abstract List<Item> createItems();
    protected abstract Player createPlayer();
}
