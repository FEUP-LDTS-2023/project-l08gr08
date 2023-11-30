package model;

public class Position {
    private int x;
    private int y;

    public Position(int a, int b){
        x = a;
        y = b;
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
