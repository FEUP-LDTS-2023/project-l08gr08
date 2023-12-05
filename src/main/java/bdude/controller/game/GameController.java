package bdude.controller.game;

import bdude.controller.Controller;

import bdude.model.game.levels.Level;

public abstract class GameController extends Controller<Level> {
    public GameController(Level level) {
        super(level);
    }
}
