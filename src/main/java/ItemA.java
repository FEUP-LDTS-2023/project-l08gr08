import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ItemA extends Element{
    public ItemA (int x, int y) {
        super(x, y);
    }
    @Override
    public void draw(TextGraphics graphics) { // change later //
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#32CD32"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "1");
    }
}