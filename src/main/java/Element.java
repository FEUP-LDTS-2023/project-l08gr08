import com.googlecode.lanterna.graphics.TextGraphics;

abstract class Element {
    private Position position;
    public Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    int playerX = 0;
    public void setPlayerX(int a){
        this.playerX = a;
    }

    int centerX = 21;
    int centerY = 4;

    public abstract void draw(TextGraphics graphics);
}