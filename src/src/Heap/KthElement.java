package Heap;

import java.util.PriorityQueue;
import java.util.Collections;

public class KthElement {
  static int kthLargets(int[] arr, int k) {
    // build Max-Heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // add all element in queue or max-heap
    for(int num: arr) {
      maxHeap.add(num);
    }
    int result = -1;
    for (int i = 0; i < k; i++) {
      result = maxHeap.poll();
    }
    return result;
  }

  static int kthSmallest(int[] arr, int k) {
    // build Min-Heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // add all element in queue or max-heap
    for(int num: arr) {
      minHeap.add(num);
    }
    int result = -1;
    for (int i = 0; i < k; i++) {
      result = minHeap.poll();
    }
    return result;
  }

  static int kthLargestSmart(int[] arr, int k) {
    // Min-Heap of size K
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int x : arr) {
      if (minHeap.size() < k) {
        // heap not full yet → just add
        minHeap.add(x);
      } else if (x > minHeap.peek()) {
        // current element bigger than smallest in heap
        // remove smallest, add current
        minHeap.poll();
        minHeap.add(x);
      }
      // else ignore - smaller than all K elements
    }

    // root = Kth largest
    return minHeap.peek();
  }


  static int kthSmallestSmart(int[] arr, int k) {
    // Min-Heap of size K
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int x : arr) {
      if (maxHeap.size() < k) {
        // heap not full yet → just add
        maxHeap.add(x);
      } else if (x < maxHeap.peek()) {
        // current element smaller than smallest in heap
        // remove bigger, add current
        maxHeap.poll();
        maxHeap.add(x);
      }
      // else ignore - smaller than all K elements
    }

    // root = Kth largest
    return maxHeap.peek();
  }
  public static void main(String[] args) {
    int[] arr = {3,9,10,21,22,11};
    System.out.println("Get K th Largets Element 2: " +  kthLargets(arr, 2));
    System.out.println("Get K th Smallest Element 2: " +  kthSmallest(arr, 2));
    System.out.println("Get K th LArgest SMart Element 4: " +  kthLargestSmart(arr, 4));
    System.out.println("Get K th Smallest Smart Element 4: " +  kthSmallestSmart(arr, 4));



  }
}
