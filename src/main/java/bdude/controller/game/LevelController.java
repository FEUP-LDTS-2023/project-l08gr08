package bdude.controller.game;

import java.io.IOException;

import bdude.Game;
import bdude.gui.GUI;
import bdude.model.game.levels.Level;
import bdude.model.menu.Menu;
import bdude.states.MenuState;

public class LevelController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;
    private final BlockController blockController;
    private final ItemController itemController;

    public LevelController(Level level) {
        super(level);
        this.playerController = new PlayerController(level);
        this.enemyController = new EnemyController(level);
        this.blockController = new BlockController(level);
        this.itemController = new ItemController(level);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            playerController.step(game, action, time);
            enemyController.step(game, action, time);
            blockController.step(game, action, time);
            itemController.step(game, action, time);
        }
    }
}