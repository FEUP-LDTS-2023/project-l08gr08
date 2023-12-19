package bdude.Model;

import bdude.model.game.elements.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnemyTest {
    @Test
    public void moveAddCounter () {
        Enemy enemy = new Enemy(0,0);
        int x = enemy.getMoveCounter();
        enemy.addCounter();
        int expected = x + 1;

        if(expected >= 5){
            expected = 0;
        }

        Assertions.assertEquals(expected, enemy.getMoveCounter());
    }
    @Test
    public void setLastYTest() {
        Enemy enemy = new Enemy(40,40);
        enemy.setLastY(30);

        Assertions.assertEquals(30,enemy.getLastY());
    }
    @Test public void testRandom() {
        Enemy enemy = new Enemy(500,500);
        boolean expected = true;

        boolean actual = enemy.getMoveCounter() >= 0 && enemy.getMoveCounter() <= 5;

        Assertions.assertEquals(actual,expected);
    }
}
