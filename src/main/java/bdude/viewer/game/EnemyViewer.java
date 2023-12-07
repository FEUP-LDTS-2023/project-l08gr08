package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy>{
    @Override
    public void draw(Enemy enemy, GUI gui){
        gui.drawEnemy(enemy.getPosition());
    }
}
