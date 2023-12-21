package bdude.Viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Player;
import bdude.viewer.game.PlayerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerViewerTest {
    private Player player;
    private Player playerSwitched;
    private Player playerPower;
    private Player playerPowerSwitched;
    private PlayerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        player = new Player(0, 0);

        playerSwitched = new Player(0,0);
        playerSwitched.switchDirection();

        playerPower = new Player(0,0);
        playerPower.power(true);
        playerPower.setPowerActive();

        playerPowerSwitched = new Player(0,0);
        playerPowerSwitched.power(true);
        playerPowerSwitched.setPowerActive();
        playerPowerSwitched.switchDirection();

        viewer = new PlayerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(player, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(player.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayer2(player.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayerPower(player.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayerPower2(player.getPosition());
    }
    @Test
    void drawElementSwitched() {
        viewer.draw(playerSwitched,gui);
        Mockito.verify(gui, Mockito.times(0)).drawPlayer(playerSwitched.getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawPlayer2(playerSwitched.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayerPower(playerSwitched.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayerPower2(playerSwitched.getPosition());
    }
    @Test
    void drawElementPower() {
        viewer.draw(playerPower, gui);
        Mockito.verify(gui, Mockito.times(0)).drawPlayer(playerPower.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayer2(playerPower.getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawPlayerPower(playerPower.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayerPower2(playerPower.getPosition());
    }
    @Test
    void drawElementPowerSwitched () {
        viewer.draw(playerPowerSwitched, gui);
        Mockito.verify(gui, Mockito.times(0)).drawPlayer(playerPowerSwitched.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayer2(playerPowerSwitched.getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawPlayerPower(playerPowerSwitched.getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawPlayerPower2(playerPowerSwitched.getPosition());
    }
}