package bdude.controller.menu;

import bdude.Game;
import bdude.controller.Controller;
import bdude.gui.GUI;
import bdude.model.game.levels.LevelReadBuilder;
import bdude.model.menu.LevelCleared;
import bdude.model.menu.Menu;
import bdude.states.GameState;
import bdude.states.MenuState;

import java.io.IOException;

public class LevelClearedController extends Controller<LevelCleared> {
    public LevelClearedController(LevelCleared model) {
        super(model);
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
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
                if (getModel().isSelectedNext()) {
                    if(getModel().getInp() == 3) game.setState(new GameState(new LevelReadBuilder(1 ,3).createLevel()));
                    else game.setState(new GameState(new LevelReadBuilder(getModel().getInp() + 1,3).createLevel()));
                }
        }
    }
}
