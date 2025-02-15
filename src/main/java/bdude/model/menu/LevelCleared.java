package bdude.model.menu;

import java.util.Arrays;
import java.util.List;

public class LevelCleared {
    private final List<String> entries;
    public int currentEntry = 0;
    private int inp = 0;

    public LevelCleared(int inp) {
        this.inp = inp;
        this.entries = Arrays.asList("GO TO NEXT LEVEL ",
                                     " RETURN TO MENU  ");
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
    public boolean isSelectedMenu() {
        return isSelected(1);
    }
    public boolean isSelectedNext(){
        return isSelected(0);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
    public int getInp(){
        return inp;
    }
}
