package bdude.model.menu;

import java.util.Arrays;
import java.util.List;

public class Controls {
    private final List<String> entries;
    private int currentEntry = 0;
    public Controls() {
        this.entries = Arrays.asList(
                "ARROW LEFT -> MOVE TO THE LEFT",
                "ARROW RIGHT -> MOVE TO THE RIGHT",
                "ARROW UP -> JUMP ONE BLOCK",
                "ARROW DOWN -> PICK UP BLOCK",
                "ARROW DOWN -> DROP BLOCK",
                "P -> ACTIVATE POWER",
                "Q -> CLOSE LEVEL",
                "GO BACK"
        );
    }
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }
    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }
    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedFirst() {
        return isSelected(0);
    }
    public boolean isSelectedSecond() {
        return isSelected(1);
    }
    public boolean isSelectedThird() {
        return isSelected(2);
    }
    public boolean isSelectedFourth() {
        return isSelected(3);
    }
    public boolean isSelectedFifth(){
        return isSelected(4);
    }
    public boolean isSelectedSixth(){
        return isSelected(5);
    }
    public boolean isSelectedSeventh() {
        return isSelected(6);
    }
    public boolean isSelectedBack(){
        return isSelected(7);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}
