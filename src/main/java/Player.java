import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element {
    private int stage; // Guarda o "Estágio // Nível do Herói // 1 -> 2 -> 3 //
    private boolean direction; // true -> direita // false -> esquerda //
    private boolean power = false; // true -> pode usar poder // falso -> não pode
    private boolean powerActive = false; // true -> tem o poder ativado // false -> não tem

    public Player(int x, int y){
        super(x,y);
    }
    public int getStage() {
        return stage;
    }
    public boolean getDirection() {
        return direction;
    }
    public boolean getPower(){
        return power;
    }
    public void setPower(boolean a){
        this.power = a;
    }
    public boolean getPowerActive(boolean a){
        return powerActive;
    }
    public void setPowerActive(boolean a){
        this.powerActive = a;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#01016f"));
        graphics.enableModifiers(SGR.BOLD);

        if(direction) graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), ">");
        if(!direction) graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "<");
    }
}
