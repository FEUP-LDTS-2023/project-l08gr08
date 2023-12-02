package bdude.gui;

import bdude.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void drawPlayer(Position position);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void drawItem(Position position);

    void clear();

    void refresh() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

}
