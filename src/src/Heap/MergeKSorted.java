import java.util.*;

public class MergeKSorted {

  static int[] mergeKSorted(int[][] arrays) {
    // Min-Heap
    // stores int[] {value, arrayIndex, elementIndex}
    PriorityQueue<int[]> minHeap =
        new PriorityQueue<>((a, b) -> a[0] - b[0]);
    //                              ↑
    //                    compare by value

    // Step 1 - add first element of each array
    int totalSize = 0;
    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i].length > 0) {
        minHeap.add(new int[]{
            arrays[i][0],  // value
            i,             // array index
            0              // element index
        });
        totalSize += arrays[i].length;
      }
    }

    // Step 2 - extract min and add next element
    int[] result = new int[totalSize];
    int idx = 0;

    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();   // extract min

      int value      = top[0];
      int arrayIndex = top[1];
      int elemIndex  = top[2];

      result[idx++] = value;        // add to result

      // add next element from same array
      int nextIndex = elemIndex + 1;
      if (nextIndex < arrays[arrayIndex].length) {
        minHeap.add(new int[]{
            arrays[arrayIndex][nextIndex],  // next value
            arrayIndex,                      // same array
            nextIndex                        // next index
        });
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[][] arrays = {
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9}
    };

    int[] result = mergeKSorted(arrays);

    System.out.print("Merged: ");
    for (int x : result) {
      System.out.print(x + " ");
    }
    // Output: Merged: 1 2 3 4 5 6 7 8 9
  }
}