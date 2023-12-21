package bdude.Controller.menu;

import bdude.Game;
import bdude.controller.menu.LevelNotClearedController;
import bdude.gui.GUI;
import bdude.model.menu.LevelNotCleared;
import bdude.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class LevelNotClearedControllerTest {

    @Mock
    private Game game;

    @Mock
    private LevelNotCleared model;

    @InjectMocks
    private LevelNotClearedController controller;

    @BeforeEach
    void setUp() {
        int inp = 1;
        MockitoAnnotations.openMocks(this);
        model = mock(LevelNotCleared.class);
        controller = new LevelNotClearedController(model);
    }

    @Test
    void upPreviousEntry() throws IOException {
        controller.step(game, GUI.ACTION.UP, 0);
        verify(model, times(1)).previousEntry();
        verifyNoInteractions(game);
    }

    @Test
    void downNextEntry() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 0);
        verify(model, times(1)).nextEntry();
        verifyNoInteractions(game);
    }

    @Test
    void selectSetMenuState() throws IOException {
        when(model.isSelectedMenu()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 0);

        verify(game, times(1)).setState(any(MenuState.class));
        verifyNoMoreInteractions(game);
    }

}
