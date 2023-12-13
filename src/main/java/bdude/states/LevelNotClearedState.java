package bdude.states;

import bdude.controller.Controller;
import bdude.controller.menu.LevelClearedController;
import bdude.controller.menu.LevelNotClearedController;
import bdude.model.menu.LevelNotCleared;
import bdude.viewer.Viewer;
import bdude.viewer.menu.LevelNotClearedViewer;

public class LevelNotClearedState extends State<LevelNotCleared> {
    public LevelNotClearedState(LevelNotCleared model) {
        super(model);
    }
    @Override
    protected Viewer<LevelNotCleared> getViewer() {
        return new LevelNotClearedViewer(getModel());
    }
    @Override
    protected Controller<LevelNotCleared> getController() {
        return new LevelNotClearedController(getModel());
    }
}
