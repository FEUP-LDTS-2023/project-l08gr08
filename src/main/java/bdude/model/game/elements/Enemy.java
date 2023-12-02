package bdude.model.game.elements;
import java.util.Random;

public class Enemy extends Element {
    public Enemy(int x, int y) {
        super(x, y);
    }

    Random random = new Random();
    private int moveCounter = random.nextInt(6);

    public void addCounter() {
        if (moveCounter == 5) {
            moveCounter = 0;
        } else moveCounter++;
    }

    private int getMoveCounter() {
        return moveCounter;
    }
}