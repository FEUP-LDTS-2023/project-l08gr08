package bdude.controller.menu;

import bdude.Game;
import bdude.controller.Controller;
import bdude.gui.GUI;
import bdude.model.game.levels.LevelReadBuilder;
import bdude.model.menu.Menu;
import bdude.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedLevel1()) game.setState(new GameState(new LevelReadBuilder(1).createLevel()));
                if (getModel().isSelectedLevel2()) game.setState(new GameState(new LevelReadBuilder(2).createLevel()));
                if (getModel().isSelectedLevel3()) game.setState(new GameState(new LevelReadBuilder(3).createLevel()));
        }
    }
}
