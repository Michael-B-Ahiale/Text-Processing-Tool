package textprocessingtool.model;

public class SavedEntry {
    private String arrayListEntry;
    private String setEntry;
    private String mapEntry;

    public SavedEntry(String arrayListEntry, String setEntry, String mapEntry) {
        this.arrayListEntry = arrayListEntry;
        this.setEntry = setEntry;
        this.mapEntry = mapEntry;
    }

    public String getArrayListEntry() { return arrayListEntry; }
    public String getSetEntry() { return setEntry; }
    public String getMapEntry() { return mapEntry; }
}