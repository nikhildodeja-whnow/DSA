import java.util.HashMap;
import java.util.Map;

public class RansomNoteHashMap {
    public static boolean checkRansom(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i =0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        boolean isRansome = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return isRansome;
    }
    public static void main(String[] args) {
        String ransomNote = "aab";
        String magazine = "baa";
        boolean isRansomNote = checkRansom(ransomNote, magazine);
        System.out.println("IsRansom----" + isRansomNote);
    }
}