package bdude.states;

import bdude.controller.Controller;
import bdude.model.menu.Menu;
import bdude.viewer.Viewer;
import bdude.viewer.menu.MenuViewer;
import bdude.controller.menu.MenuController;


public class MenuState extends State<Menu>{
    public MenuState(Menu model) {
        super(model);
    }
    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }
    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
