package bdude.model.game.elements;

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
}
