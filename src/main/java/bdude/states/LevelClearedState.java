package bdude.states;

import bdude.controller.Controller;
import bdude.controller.menu.LevelClearedController;
import bdude.model.menu.LevelCleared;
import bdude.viewer.Viewer;
import bdude.viewer.menu.LevelClearedViewer;

public class LevelClearedState extends State<LevelCleared>{
    public LevelClearedState(LevelCleared model) {
        super(model);
    }
    @Override
    protected Viewer<LevelCleared> getViewer() {
        return new LevelClearedViewer(getModel());
    }
    @Override
    protected Controller<LevelCleared> getController() {
        return new LevelClearedController(getModel());
    }
}
