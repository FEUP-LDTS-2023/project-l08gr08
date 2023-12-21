package bdude.Controller.menu;

import bdude.Game;
import bdude.controller.menu.ControlsController;
import bdude.gui.GUI;
import bdude.model.menu.Controls;
import bdude.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ControlsControllerTest {
    private ControlsController controlsController;
    private Controls controls;
    private Game game;

    @BeforeEach
    void setUp() {
        controls = mock(Controls.class);
        controlsController = new ControlsController(controls);
        game = mock(Game.class);
    }

    @Test
    void stepSelectWithSelectedBack() throws IOException {
        when(controls.isSelectedBack()).thenReturn(true);

        controlsController.step(game, GUI.ACTION.SELECT, 1000L);

        verify(game).setState(any(MenuState.class));
    }

    @Test
    void stepSelectWithoutSelectedBack() throws IOException {
        when(controls.isSelectedBack()).thenReturn(false);

        controlsController.step(game, GUI.ACTION.SELECT, 1000L);

        verify(game, never()).setState(any(MenuState.class));
    }

    @Test
    void stepWithNonSelectAction() throws IOException {
        controlsController.step(game, GUI.ACTION.UP, 1000L);

        verify(game, never()).setState(any(MenuState.class));
        verify(controls, never()).isSelectedBack();
    }
}
