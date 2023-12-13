package bdude.controller.menu;

import bdude.Game;
import bdude.controller.Controller;
import bdude.gui.GUI;
import bdude.model.game.levels.LevelReadBuilder;
import bdude.model.menu.LevelNotCleared;
import bdude.model.menu.Menu;
import bdude.states.GameState;
import bdude.states.MenuState;

import java.io.IOException;

public class LevelNotClearedController extends Controller<LevelNotCleared> {
    public LevelNotClearedController(LevelNotCleared model) {
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
                    game.setState(new GameState(new LevelReadBuilder(getModel().getInp() ,3).createLevel()));
                }
        }
    }
}
