package SelfDSA;
import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class slidingWindow {

  public static int sumGreaterThanEqualToTarget(int[] arr, int target) {
    int minLength = Integer.MAX_VALUE;
    if (arr.length == 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    int sum = 0;

    while (right < arr.length) {
      sum += arr[right];
      while (sum >= target) {
        minLength = Math.min(right - left + 1, minLength);
        sum -= arr[left];
        left++;
      }
      right++;
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

  public static int continuesStringWithoutDuplicate1(String str) {
    if (str.length() == 0) return 0;
    Set<Character> set = new HashSet<>();
    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < str.length(); right++) {
      char current = str.charAt(right);
      while (set.contains(current)) {
        set.remove(str.charAt(left));
        left++;
      }
      set.add(current);
      maxLength = Math.max(right - left + 1, maxLength);
    }
    System.out.println(set.toString());
    return maxLength;
  }

  public static int continuesStringWithoutDuplicate(String str) {
    int maxLength = Integer.MIN_VALUE;
    Set<Character> uniqueCharSet = new HashSet<>();
    int left = 0;
    for(int right = 0; right < str.length(); right++) {
      char currentCharacter = str.charAt(right);
      if(uniqueCharSet.contains(currentCharacter)) {
        uniqueCharSet.remove(str.charAt(left)); // remove from left
        left++;
      }
      uniqueCharSet.add(currentCharacter);
      maxLength = Math.max(uniqueCharSet.size(), maxLength);
    }
    System.out.println(uniqueCharSet.toString());
    return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
  }

  public static boolean isStringPalindrom(String str) {
    if (str == null || str.length() == 0) return true;

    int left = 0;
    int right = str.length() - 1;
    while(left<=right) {
      if (str.charAt(left) != str.charAt(right)) return false;
      left++;
      right--;
    }
    return true;
  }

  public static boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    Map<Character, Integer> anagramMap = new HashMap<>();
    for (char c: str1.toCharArray()) {
      anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);
    }
    for (char c: str2.toCharArray()) {
      if(anagramMap.containsKey(c)) {
        anagramMap.put(c, anagramMap.getOrDefault(c, 0) - 1);
        if (anagramMap.get(c) < 0) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public static char firstCharacterWith1Frequency(String str) {
    if (str.length() == 0) {
      return '\0';
    }
    Map<Character, Integer> countCharacterMap = new HashMap<>();
    for (char c: str.toCharArray()) {
      countCharacterMap.put(c,countCharacterMap.getOrDefault(c, 0) + 1);
    }
    for(Map.Entry<Character, Integer> entry: countCharacterMap.entrySet()) {
      Integer value = entry.getValue();
      if (value == 1) {
        return entry.getKey();
      }
    }
    return '\0';
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 2, 4, 3};
    System.out.println("Sum Greater than equal Target 7 : Expected Length: => " + sumGreaterThanEqualToTarget(arr, 7)); // add this!
    String str = "abcdbd";
    int maxUniqueCharacterInString = continuesStringWithoutDuplicate1(str);
    System.out.println("Max Unique Character in strings are : = " + maxUniqueCharacterInString);
    System.out.println("STRTS is palindrom => " + isStringPalindrom("STRTS"));
    System.out.println("Listen and Silent are Anagram or not : " + isAnagram("listen", "silent"));

    System.out.println("First ocurrance of unique char in apple -> " + firstCharacterWith1Frequency("aapple")); // Returns 'l'
    System.out.println("First ocurrance of unique char in swiss -> " + firstCharacterWith1Frequency("swiss"));  // Returns 'w'
    System.out.println("First ocurrance of unique char in aabbcc -> " + firstCharacterWith1Frequency("aabbcc"));
  }
}
