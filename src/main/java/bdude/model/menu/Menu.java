package bdude.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    public int currentEntry = 0;
    public Menu() {
        this.entries = Arrays.asList(" LEVEL - 1", " LEVEL - 2", " LEVEL - 3", " CONTROLS", "   EXIT");
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
    public boolean isSelectedExit() {
        return isSelected(4);
    }
    public boolean isSelectedLevel3() {
        return isSelected(2);
    }
    public boolean isSelectedLevel2() {
        return isSelected(1);
    }
    public boolean isSelectedLevel1() {
        return isSelected(0);
    }
    public boolean isSelectedControls() { return isSelected(3); }
    public int getNumberEntries() {
        return this.entries.size();
    }
}