package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        gui.drawEnemy(enemy.getPosition());

        if (enemy.getMoveCounter() == 5){
            for (int i = enemy.getPosition().getY() + 1; i <= enemy.getLastY(); i++){
                gui.drawEnemyRay(new Position(enemy.getPosition().getX(), i));
            }
        }
    }
}
