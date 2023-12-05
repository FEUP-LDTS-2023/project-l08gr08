import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Block extends Element {
    public Block(int x, int y) {
        super(x, y);
    }
    private boolean movable = false;
    public boolean isMovable() {
        return movable;
    }
    public void makeMovable() {
        this.movable = true;
    }
    
    @Override
    public void draw(TextGraphics graphics) { // change later // make texture for block and movable block //
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        if (isMovable()) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#f0ff4f"));
            graphics.putString(new TerminalPosition(centerX + getPosition().getX() - diff, centerY + getPosition().getY()), "M");
        }
        else {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#6b431c"));
            graphics.putString(new TerminalPosition(centerX + getPosition().getX() - diff , centerY + getPosition().getY()), "B");
        }
    }
}