package bdude.viewer.game;

import bdude.gui.GUI;
import bdude.model.game.elements.Player;

public class PlayerViewer implements ElementViewer<Player>{
    @Override
    public void draw (Player player, GUI gui){
        gui.drawPlayer(player.getPosition());
    }
}
