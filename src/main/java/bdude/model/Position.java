package bdude.model;

public class Position {
    private final int x;
    private final int y;

    public Position(int a, int b){
        x = a;
        y = b;
    }
    public Position getLeft() {
        return new Position(x - 1, y);
    }
    public Position getRight() {
        return new Position(x + 1, y);
    }
    public Position getUp() {
        return new Position(x, y + 1);
    }
    public Position getDown() {
        return new Position(x, y - 1);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Position p = (Position) obj;
        return x == p.getX() && y == p.getY();
    }
}
