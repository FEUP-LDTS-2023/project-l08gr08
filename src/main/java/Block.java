import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Block extends Element {
    public Block(int x, int y) {
        super(x, y);
    }

    private boolean movable = false;

    public void makeMovable() {
        this.movable = true;
    }

    @Override
    public void draw(TextGraphics graphics) { // change later //
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);

        if (movable) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#f0ff4f"));
            graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "M");

        }
        else{
            graphics.setBackgroundColor(TextColor.Factory.fromString("#6b431c"));
            graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "B");
        }

    }
}