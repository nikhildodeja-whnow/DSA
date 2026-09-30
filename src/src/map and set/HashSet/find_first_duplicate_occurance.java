import java.util.HashSet;

public class find_first_duplicate_occurance {

    public static int findDuplicateFirstOccurance(int[] arr){
        if (arr.length <= 0) {
          return -1;
        }
        int firstOccurance = -1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
          if (!hashSet.contains(arr[i])) {
            hashSet.add(arr[i]);
            continue;
          } else {
            return arr[i];
          }          
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,4,4,4,5,5,6,6,7,8,9};
        int firstDuplicateOcurrance = findDuplicateFirstOccurance(arr);
        System.out.println("first Duplicate Ocurrance: " + firstDuplicateOcurrance);
        
    }
}