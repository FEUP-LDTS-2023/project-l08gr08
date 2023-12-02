package bdude.model.game.elements;

public class Player extends Element {
    private int stage = 1;                // Guarda o "Estágio // Nível do Herói // 1 -> 2 -> 3 //
    private boolean direction = true;     // true -> direita // false -> esquerda //
    private boolean power = false;        // true -> pode usar poder // falso -> não pode //
    private boolean powerActive = false;  // true -> tem o poder ativado // false -> não tem //
    private boolean holdingBlock = false; // true -> segura no bloco // false -> não segura //

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
}