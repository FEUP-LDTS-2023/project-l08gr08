package bdude.controller.menu;

import bdude.Game;
import bdude.controller.Controller;
import bdude.gui.GUI;
import bdude.model.menu.Controls;
import bdude.model.menu.Menu;
import bdude.states.MenuState;

import java.io.IOException;

public class ControlsController extends Controller<Controls> {
    public ControlsController(Controls model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                if (getModel().isSelectedBack()) game.setState(new MenuState(new Menu()));
        }
    }
}
