import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element {
    // Create attributes //
    private int stage = 1;                // Guarda o "Estágio // Nível do Herói // 1 -> 2 -> 3 //
    private boolean direction = true;     // true -> direita // false -> esquerda //
    private boolean power = false;        // true -> pode usar poder // falso -> não pode //
    private boolean powerActive = false;  // true -> tem o poder ativado // false -> não tem //
    private boolean holdingBlock = false; // true -> segura no bloco // false -> não segura //

    // Getters and Setters for every attribute //
    public Player(int x, int y) {
        super(x, y);
    }
    public int getStage() {
        return stage;
    }
    public void nextStage() {
        if (stage == 3) {
            stage = 1;
        } else stage++;
    }
    public boolean getDirection() {
        return direction;
    }
    public void switchDirection() {
        direction = !direction;
    }
    public boolean getPower() {
        return power;
    }
    public void Power(boolean a) {
        this.power = a;
    }
    public boolean getPowerActive(boolean a) {
        return powerActive;
    }
    public void setPowerActive(boolean a) {
        this.powerActive = a;
    }
    public boolean getHoldingBlock() {
        return holdingBlock;
    }
    public void setHoldingBlock(boolean h) {
        this.holdingBlock = h;
    }

    // Draw method defined //
    @Override
    public void draw(TextGraphics graphics) {
        if (!powerActive) graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        else graphics.setForegroundColor(TextColor.Factory.fromString("#ff0000"));

        if (stage == 1) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.enableModifiers(SGR.BOLD);
        }
        else if (stage == 2) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#add8e6"));
            graphics.enableModifiers(SGR.BOLD);
        }
        else {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000080"));
            graphics.enableModifiers(SGR.BOLD);

        }
        if (direction) graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), ">");
        if (!direction) graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "<");
    }
}
