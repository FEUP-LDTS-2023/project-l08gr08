package bdude.Viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Enemy;
import bdude.viewer.game.EnemyViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EnemyViewerTest {
    private Enemy enemy;
    private EnemyViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        enemy = new Enemy(0,0);
        viewer = new EnemyViewer();
        gui = Mockito.mock(GUI.class);
        enemy.addCounter();
    }
    @Test
    void enemyDrawTest() {
        viewer.draw(enemy,gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(enemy.getPosition());

        if (enemy.getMoveCounter() == 5){
            Mockito.verify(gui, Mockito.times(1)).drawEnemyRay(enemy.getPosition().getDown());
        }
    }
}
