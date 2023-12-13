package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.Position;
import bdude.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        gui.drawEnemy(enemy.getPosition());

        int newY = enemy.getPosition().getY() + 1;

        if (enemy.getMoveCounter() == 5){
            while(newY > enemy.getLastY()){
                gui.drawEnemyRay(new Position(enemy.getPosition().getX(), newY));
                newY--;
            }
        }
    }
}
