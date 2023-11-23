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
    @Override
    public void draw(TextGraphics graphics) {
        if(id == 1) graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "1");
        if(id == 2) graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "2");
        if(id == 3) graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "3");

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#32CD32"));
        graphics.enableModifiers(SGR.BOLD);
    }
}