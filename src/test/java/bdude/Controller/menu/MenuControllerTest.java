package bdude.Controller.menu;

import bdude.Game;
import bdude.controller.menu.MenuController;
import bdude.gui.GUI;
import bdude.model.menu.Menu;
import bdude.states.ControlsState;
import bdude.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuControllerTest {

    private MenuController menuController;
    private Game gameMock;
    private Menu menuMock;

    @BeforeEach
    void setUp() {
        menuMock = mock(Menu.class);
        gameMock = mock(Game.class);
        menuController = new MenuController(menuMock);
    }

    @Test
    void testStepUp() throws IOException {
        // Arrange
        when(menuMock.isSelectedExit()).thenReturn(true);

        // Act
        menuController.step(gameMock, GUI.ACTION.UP, 0);

        // Assert
        verify(menuMock, times(1)).previousEntry();
        verify(gameMock, times(0)).setState(any());
    }

    @Test
    void testStepDown() throws IOException {
        // Arrange
        when(menuMock.isSelectedExit()).thenReturn(true);

        // Act
        menuController.step(gameMock, GUI.ACTION.DOWN, 0);

        // Assert
        verify(menuMock, times(1)).nextEntry();
        verify(gameMock, times(0)).setState(any());
    }

    @Test
    void testStepSelectExit() throws IOException {
        // Arrange
        when(menuMock.isSelectedExit()).thenReturn(true);

        // Act
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);

        // Assert
        verify(gameMock, times(1)).setState(null);
    }

    @Test
    void testStepSelectLevel1() throws IOException {
        // Arrange
        when(menuMock.isSelectedLevel1()).thenReturn(true);
        when(menuMock.isSelectedExit()).thenReturn(false);

        // Act
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);

        // Assert
        verify(gameMock, times(1)).setState(Mockito.any(GameState.class));
        verify(gameMock, times(0)).setState(Mockito.any(ControlsState.class));
    }

    @Test
    void testStepSelectLevel2() throws IOException {
        // Arrange
        when(menuMock.isSelectedLevel2()).thenReturn(true);
        when(menuMock.isSelectedExit()).thenReturn(false);

        // Act
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);

        // Assert
        verify(gameMock, times(1)).setState(Mockito.any(GameState.class));
        verify(gameMock, times(0)).setState(Mockito.any(ControlsState.class));
    }

    @Test
    void testStepSelectLevel3() throws IOException {
        // Arrange
        when(menuMock.isSelectedLevel3()).thenReturn(true);
        when(menuMock.isSelectedExit()).thenReturn(false);

        // Act
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);

        // Assert
        verify(gameMock, times(1)).setState(Mockito.any(GameState.class));
        verify(gameMock, times(0)).setState(Mockito.any(ControlsState.class));
    }

    @Test
    void testStepSelectControls() throws IOException {
        // Arrange
        when(menuMock.isSelectedControls()).thenReturn(true);
        when(menuMock.isSelectedExit()).thenReturn(false);

        // Act
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);

        // Assert
        verify(gameMock, times(1)).setState(Mockito.any(ControlsState.class));
        verify(gameMock, times(0)).setState(Mockito.any(GameState.class));
    }
}
