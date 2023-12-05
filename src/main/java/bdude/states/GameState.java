package bdude.states;

import bdude.controller.Controller;
import bdude.controller.game.LevelController;
import bdude.model.game.levels.Level;
import bdude.viewer.Viewer;
import bdude.viewer.game.GameViewer;

public class GameState extends State<Level>{
    public GameState(Level level) {
        super(level);
    }

    @Override
    protected Viewer<Level> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Level> getController() {
        return new LevelController(getModel());
    }
}
