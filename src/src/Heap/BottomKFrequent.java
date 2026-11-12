package Heap;

import java.util.*;

public class BottomKFrequent {

  static int[] bottomKFrequent(int[] arr, int k) {

    // Step 1 - Count frequency using HashMap
    HashMap<Integer, Integer> freqMap = new HashMap<>();

    for (int x : arr) {
      freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
    }
    // freqMap = {1:3, 2:2, 3:1}

    // Step 2 - Max-Heap of size K
    // ONLY CHANGE from Top K!
    // sorted by frequency descending (max-heap)
    PriorityQueue<int[]> maxHeap =
        new PriorityQueue<>((a, b) -> b[0] - a[0]);
    //                              ↑
    //                    b-a = descending = max-heap

    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      int element = entry.getKey();
      int freq    = entry.getValue();

      if (maxHeap.size() < k) {
        // heap not full → just add
        maxHeap.add(new int[]{freq, element});

      } else if (freq < maxHeap.peek()[0]) {
        // LESS frequent than root → remove root, add new
        maxHeap.poll();
        maxHeap.add(new int[]{freq, element});
      }
      // else → more frequent → skip
    }

    // Step 3 - Extract elements from heap
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = maxHeap.poll()[1];  // take element (index 1)
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 2, 2, 3};
    int k = 2;

    int[] result = bottomKFrequent(arr, k);

    System.out.print("Bottom " + k + " frequent: ");
    for (int x : result) {
      System.out.print(x + " ");
    }
    // Output: Bottom 2 frequent: 2 3
  }
}