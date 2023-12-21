package bdude.Controller.menu;

import bdude.Game;
import bdude.controller.menu.LevelClearedController;
import bdude.gui.GUI;
import bdude.model.game.levels.LevelReadBuilder;
import bdude.model.menu.LevelCleared;
import bdude.model.menu.Menu;
import bdude.states.GameState;
import bdude.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class LevelClearedControllerTest {

    private LevelClearedController controller;

    @Mock
    private Game game;

    @Mock
    private LevelCleared model;

    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        model = mock(LevelCleared.class);
        controller = new LevelClearedController(model);
    }

    @Test
    void stepUp() throws Exception {
        when(model.isSelectedMenu()).thenReturn(false);
        when(model.isSelectedNext()).thenReturn(false);
        assertDoesNotThrow(() -> controller.step(game, GUI.ACTION.UP, 0));
        verify(model).previousEntry();
        verifyNoInteractions(game);
    }

    @Test
    void stepDown() throws Exception {
        when(model.isSelectedMenu()).thenReturn(false);
        when(model.isSelectedNext()).thenReturn(false);
        assertDoesNotThrow(() -> controller.step(game, GUI.ACTION.DOWN, 0));
        verify(model).nextEntry();
        verifyNoInteractions(game);
    }

    @Test
    void stepSelectMenu() throws Exception {
        when(model.isSelectedMenu()).thenReturn(true);
        when(model.isSelectedNext()).thenReturn(false);
        assertDoesNotThrow(() -> controller.step(game, GUI.ACTION.SELECT, 0));
        verify(game).setState(any(MenuState.class));
        verifyNoMoreInteractions(game);
    }


    @Test
    void stepInvalidAction() throws Exception {
        when(model.isSelectedMenu()).thenReturn(false);
        when(model.isSelectedNext()).thenReturn(false);
        assertDoesNotThrow(() -> controller.step(game, GUI.ACTION.LEFT, 0));
        verifyNoInteractions(model);
        verifyNoInteractions(game);
    }

}
