package Heap;

import java.util.*;

public class TopKFrequent {

  static int[] topKFrequent(int[] arr, int k) {

    // Step 1 - Count frequency using HashMap
    HashMap<Integer, Integer> freqMap = new HashMap<>();

    for (int x : arr) {
      freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
    }
    // freqMap = {1:3, 2:2, 3:1}

    // Step 2 - Min-Heap of size K
    // stores int[] {frequency, element}
    // sorted by frequency (index 0)
    PriorityQueue<int[]> minHeap =
        new PriorityQueue<>((a, b) -> a[0] - b[0]);

    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      int element = entry.getKey();
      int freq    = entry.getValue();

      if (minHeap.size() < k) {
        // heap not full → just add
        minHeap.add(new int[]{freq, element});

      } else if (freq > minHeap.peek()[0]) {
        // more frequent than root → remove root, add new
        minHeap.poll();
        minHeap.add(new int[]{freq, element});
      }
      // else → less frequent → skip
    }

    // Step 3 - Extract elements from heap
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll()[1];  // take element (index 1)
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr = {18, 18, 18, 17, 17, 2,2,2,1,1,3,3};
    int k = 2;

    int[] result = topKFrequent(arr, k);

    System.out.print("Top " + k + " frequent: ");
    for (int x : result) {
      System.out.print(x + " ");
    }
    // Output: Top 2 frequent: 2 1
  }
}