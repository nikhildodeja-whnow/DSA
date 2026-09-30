package Questions;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteWithFrequency {
    public static boolean checkRansom(String ransomNote, String magazine) {
        boolean isRansome = true;
        int[] frequency = new int[26];
        for (int i = 0; i <  ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int position = c - 'a';
            frequency[position] += 1;
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int position = c - 'a';
            if (frequency[position] > 0) {
                frequency[position] -= 1;
            }
        }
        // Step 3: Check if anything is still required
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = "aab";
        String magazine = "ab";
        boolean isRansomNote = checkRansom(ransomNote, magazine);
        System.out.println("IsRansom----" + isRansomNote);
    }
}