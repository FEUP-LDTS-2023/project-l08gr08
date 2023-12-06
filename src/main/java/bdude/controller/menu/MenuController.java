package bdude.controller.menu;

import bdude.Game;
import bdude.controller.Controller;
import bdude.gui.GUI;
import bdude.model.menu.Menu;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
