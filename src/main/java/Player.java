import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element {
    private int stage;           // Guarda o "Estágio // Nível do Herói // 1 -> 2 -> 3 //
    private boolean direction;  // true -> direita // false -> esquerda //

    public Player(int x, int y){
        super(x,y);
    }
    public int getStage() {
        return stage;
    }
    public boolean getDirection() {
        return direction;
    }

    @Override
    public void draw(TextGraphics graphics) {
    }
}
