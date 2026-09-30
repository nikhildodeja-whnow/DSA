import java.util.HashSet;
import java.util.ArrayList;

public class find_the_common_element {

  public static int[] findCommonElement(int[] arr1, int[] arr2) {
    if (arr1.length == 0 || arr2.length == 0) {
      return new int[] {};
    }
    HashSet<Integer> hashSet = new HashSet<>();
    for (int i = 0;i < arr1.length; i++) {
      if (!hashSet.contains(arr1[i])) {
        hashSet.add(arr1[i]);
      }
    }

    ArrayList<Integer> returnArr = new ArrayList<>();
    int k = 0;
    for (int i = 0; i < arr2.length; i++) {
      if (hashSet.contains(arr2[i])) {
        returnArr.add(arr2[i]);
        hashSet.remove(arr2[i]);
        k++;
      }
    }
        // Convert ArrayList to int[]
    int[] result = new int[returnArr.size()];
    for (int i = 0; i < returnArr.size(); i++) {
      result[i] = returnArr.get(i);
    }
    return result;
  }
  public static void main(String[] args) {
    int arr1[] = new int[] {1,2,3,4,5};
    int arr2[] = new int[] {4,5,6,7,8,9};
    int[] commonElement = findCommonElement(arr1, arr2);
    for (int i = 0; i < commonElement.length; i++) {
      System.out.print(commonElement[i] + " ");
    }
        System.out.println(); // <-- Add this newline!

  }
}