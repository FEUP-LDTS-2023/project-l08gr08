package bdude.gui;

import bdude.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayer(Position position);
    void drawPlayer2(Position position);
    void drawPlayerPower(Position position);
    void drawPlayerPower2(Position position);

    void drawBlock(Position position);
    void drawMovableBlock(Position position);
    void drawHoldingBlock(Position position);

    void drawItem1(Position position);
    void drawItem2(Position position);
    void drawItem3(Position position);

    void drawEnemy(Position position);

    void drawWall(Position position);

    void drawText(Position position, String text, String color);

    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, POWER, RESTART}
}
