import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Enemy extends Element {
    public Enemy (int x, int y){
        super(x,y);
    }
    private int moveCounter = 0;

    public void addCounter() {
        if(moveCounter == 3){
            moveCounter = 0;
        }
        else moveCounter++;
    }
    private int getMoveCounter(){
        return moveCounter;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5a0075"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "E");
    }
}
