package bdude.Controller.game;

import bdude.Game;
import bdude.controller.game.*;
import bdude.gui.GUI;
import bdude.model.game.levels.Level;
import bdude.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LevelControllerTest {
    private LevelController levelController;
    private Game game;
    private GUI.ACTION action;
    private long time;

    @BeforeEach
    void setUp() {
        Level level = mock(Level.class);
        levelController = new LevelController(level);
        game = mock(Game.class);
        action = GUI.ACTION.UP;
        time = 1000L;
    }

    @Test
    void stepWithQuitAction() throws IOException {
        action = GUI.ACTION.QUIT;
        levelController.step(game, action, time);
        verify(game).setState(any(MenuState.class));
    }

    @Test
    void stepWithoutQuitAction() throws IOException {
        levelController.playerController = mock(PlayerController.class);
        levelController.enemyController = mock(EnemyController.class);
        levelController.blockController = mock(BlockController.class);
        levelController.itemController = mock(ItemController.class);

        levelController.step(game, action, time);

        verify(levelController.playerController).step(game, action, time);
        verify(levelController.enemyController).step(game, action, time);
        verify(levelController.blockController).step(game, action, time);
        verify(levelController.itemController).step(game, action, time);
    }
}
