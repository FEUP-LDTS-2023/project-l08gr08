package bdude.model.game.elements;
import java.util.Random;

public class Enemy extends Element {
    public Enemy(int x, int y) {
        super(x, y);
    }

    private int lastY = 1;

    Random random = new Random();
    private int moveCounter = random.nextInt(3);

    public void addCounter() {
        if (moveCounter == 5) {
            moveCounter = 0;
        } else moveCounter++;
    }
    public void setLastY(int a){
        this.lastY = a;
    }
    public int getLastY(){
        return lastY;
    }

    public int getMoveCounter() {
        return moveCounter;
    }
}