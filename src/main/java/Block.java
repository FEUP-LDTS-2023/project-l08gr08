import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Block extends Element {
    public Block(int x, int y) {
        super(x, y);
    }
    private boolean movable = false;
    private int playerX = 0;
    public void setPlayerX(int a){
        this.playerX = a;
    }
    public void makeMovable() {
        this.movable = true;
    }

    private int limitXBig = 51;
    private int limitXSmall = 20;
    private int diff = 0;

    public void switchLimits(){
        if (playerX > 14){
            diff = playerX - 14;
            limitXBig = diff + limitXBig;
            limitXSmall = diff + limitXSmall;
        }
    }
    @Override
    public void draw(TextGraphics graphics) { // change later // make texture for block and movable block //
        int x = getPosition().getX();

        if(x > limitXSmall && x < limitXBig){
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            if (movable) {
                graphics.setBackgroundColor(TextColor.Factory.fromString("#f0ff4f"));
                graphics.putString(new TerminalPosition(getPosition().getX()- diff , getPosition().getY()), "M");
            } else {
                graphics.setBackgroundColor(TextColor.Factory.fromString("#6b431c"));
                graphics.putString(new TerminalPosition(getPosition().getX() - diff, getPosition().getY()), "B");
            }
        }
    }
}