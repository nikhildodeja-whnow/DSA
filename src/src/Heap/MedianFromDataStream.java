package Heap;

import java.util.*;

public class MedianFromDataStream {

  public static void main(String[] args) {
    int[] stream = {1, 2, 5, 4, 3, 90, 101};
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : stream) {

      // Step 1 - Insert
      if (maxHeap.isEmpty()) {
        maxHeap.offer(num);
      } else {
        if (num > maxHeap.peek()) {
          minHeap.offer(num);
        } else {
          maxHeap.offer(num);
        }
      }

      // Step 2 - Rebalance
      if (minHeap.size() > maxHeap.size()) {
        maxHeap.offer(minHeap.poll());
      } else if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      }

      // Step 3 - Calculate median
      int size = minHeap.size() + maxHeap.size();
      double result;
      if (size % 2 != 0) {
        result = maxHeap.peek();
      } else {
        result = (maxHeap.peek() + minHeap.peek()) / 2.0;
      }

      System.out.println("Insert " + num + " → median = " + result);
    }
  }
}