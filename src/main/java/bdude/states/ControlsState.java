package bdude.states;

import bdude.controller.Controller;
import bdude.controller.menu.ControlsController;
import bdude.model.menu.Controls;
import bdude.viewer.Viewer;
import bdude.viewer.menu.ControlsViewer;

public class ControlsState extends State<Controls>{
    public ControlsState(Controls model) {
        super(model);
    }
    @Override
    protected Viewer<Controls> getViewer() {
        return new ControlsViewer(getModel());
    }
    @Override
    protected Controller<Controls> getController() {
        return new ControlsController(getModel());
    }
}
