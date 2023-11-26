import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Item extends Element{
    private int id = 1;
    public Item (int x, int y) {
        super(x, y);
    }
    public void switchId(int a){
        this.id = a;
    }
    public int getId() {
        return id;
    }
    @Override
    public void draw(TextGraphics graphics) {
        int x = getPosition().getX();

            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            graphics.setBackgroundColor(TextColor.Factory.fromString("#32CD32"));
            graphics.enableModifiers(SGR.BOLD);

            if (id == 1)
                graphics.putString(new TerminalPosition(centerX + getPosition().getX(), centerY + getPosition().getY()), "1");
            else if (id == 2)
                graphics.putString(new TerminalPosition(centerX + getPosition().getX(), centerY + getPosition().getY()), "2");
            else graphics.putString(new TerminalPosition(centerX + getPosition().getX(), centerY + getPosition().getY()), "3");
    }
}