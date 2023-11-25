import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.util.Random;

public class Enemy extends Element {
    public Enemy (int x, int y){
        super(x,y);
    }
    Random random = new Random();
    private int moveCounter = random.nextInt(6);

    public void addCounter() {
        if(moveCounter == 5){
            moveCounter = 0;
        }
        else moveCounter++;
    }
    private int getMoveCounter(){
        return moveCounter;
    }

    @Override
    public void draw(TextGraphics graphics) {
        int x = getPosition().getX();
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            graphics.setBackgroundColor(TextColor.Factory.fromString("#5a0075"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(centerX + getPosition().getX(), centerY + getPosition().getY()), "E");
    }
}
