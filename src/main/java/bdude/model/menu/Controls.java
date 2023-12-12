package bdude.model.menu;

import java.util.Arrays;
import java.util.List;

public class Controls {
    private final List<String> entries;
    private int currentEntry = 9;
    public Controls() {
        this.entries = Arrays.asList(
                "ARROW LEFT -> MOVE TO THE LEFT",
                "ARROW RIGHT -> MOVE TO THE RIGHT",
                "ARROW UP -> JUMP ONE BLOCK",
                "ARROW DOWN -> PICK UP BLOCK",
                "ARROW DOWN -> DROP BLOCK",
                "P -> ACTIVATE POWER",
                "ENTER -> USE POWER",
                "Q -> CLOSE LEVEL",
                "R -> RESTART LEVEL",
                "GO BACK"
        );
    }
    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedBack(){
        return isSelected(9);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}
