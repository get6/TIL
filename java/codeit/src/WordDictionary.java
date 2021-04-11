import java.util.*;

public class WordDictionary {

    private Map<String, String> dict;

    WordDictionary() {
        this.dict = new HashMap<>();
    }

    public void addWord(String key, String value) {
        dict.put(key, value);
    }

    public String find(String findKey) {
        findKey = findKey.toLowerCase();
        for (String key : dict.keySet()) {
            if (findKey.equalsIgnoreCase(key)) {
                return dict.get(key);
            }
        }
        return null;
    }
}