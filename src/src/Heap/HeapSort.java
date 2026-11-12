package Heap;

public class HeapSort {

  // BubbleDown for heap sort
  static void bubbleDown(int[] arr, int n, int i) {
    int largest = i;
    int left  = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      // swap
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;

      bubbleDown(arr, n, largest);
    }
  }

  // Heap Sort
  static void heapSort(int[] arr) {
    int n = arr.length;

    // Phase 1 - Build Max-Heap
    for (int i = (n / 2) - 1; i >= 0; i--) {
      bubbleDown(arr, n, i);
    }

    // Phase 2 - Extract max one by one
    for (int i = n - 1; i > 0; i--) {
      // swap root with last
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // bubbleDown on reduced heap
      bubbleDown(arr, i, 0);
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 9, 2, 1, 4};

    System.out.print("Before: ");
    for (int x : arr) System.out.print(x + " ");

    heapSort(arr);

    System.out.print("\nAfter:  ");
    for (int x : arr) System.out.print(x + " ");
  }
}