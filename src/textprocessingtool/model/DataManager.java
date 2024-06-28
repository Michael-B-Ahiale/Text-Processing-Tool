package textprocessingtool.model;

import java.util.*;

public class DataManager {
    private List<String> simpleList;
    private Set<String> uniqueSet;
    private Map<String, TextEntry> textEntries;

    public DataManager() {
        simpleList = new ArrayList<>();
        uniqueSet = new HashSet<>();
        textEntries = new HashMap<>();
    }

    public void addToList(String item) {
        simpleList.add(item);
    }

    public boolean removeFromList(String item) {
        return simpleList.remove(item);
    }

    public List<String> getSimpleList() {
        return new ArrayList<>(simpleList);
    }

    public boolean addToSet(String item) {
        return uniqueSet.add(item);
    }

    public boolean removeFromSet(String item) {
        return uniqueSet.remove(item);
    }

    public Set<String> getUniqueSet() {
        return new HashSet<>(uniqueSet);
    }

    public void addTextEntry(TextEntry entry) {
        textEntries.put(entry.getId(), entry);
    }

    public TextEntry getTextEntry(String id) {
        return textEntries.get(id);
    }

    public TextEntry updateTextEntry(String id, String newContent) {
        TextEntry entry = textEntries.get(id);
        if (entry != null) {
            entry.setContent(newContent);
            return entry;
        }
        return null;
    }

    public TextEntry removeTextEntry(String id) {
        return textEntries.remove(id);
    }

    public Map<String, TextEntry> getAllTextEntries() {
        return new HashMap<>(textEntries);
    }
}