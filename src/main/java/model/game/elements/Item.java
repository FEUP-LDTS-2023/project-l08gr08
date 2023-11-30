package model.game.elements;

public class Item extends Element {
    private int id = 1;
    public Item(int x, int y) {
        super(x, y);
    }
    public void switchId(int a) {
        this.id = a;
    }
    public int getId() {
        return id;
    }
}
