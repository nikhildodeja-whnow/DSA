package Heap;
// buuble up when max heap
public class MaxHeap {
  int[] arr;
  int size;

  public MaxHeap(int capacity) {
    arr = new int[capacity];
    size = 0;
  }

  private void swap(int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Get Parent Index
  private int parent(int i) {
    return (i - 1) / 2;
  }
  // get left and right
  private int leftChild(int i) { return 2 * i + 1; }
  private int rightChild(int i) { return 2 * i + 2; }

  // insert + buuble up
  public void insert(int value) {
    arr[size] = value;
    int i = size;
    size++;

    while (i > 0 && arr[i] > arr[parent(i)]) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  // Bubble Down (after extract)
  private void bubbleDown(int i) {
    int largest = i;             // assume current is largest
    int left = leftChild(i);
    int right = rightChild(i);

    // check if left child is larger
    if (left < size && arr[left] > arr[largest]) {
      largest = left;
    }

    // check if right child is larger
    if (right < size && arr[right] > arr[largest]) {
      largest = right;
    }

    // if largest is not current node → swap and continue
    if (largest != i) {
      swap(i, largest);
      bubbleDown(largest);     // recurse down
    }
  }

  // Extract Max
  public int extractMax() {
    if (size == 0) return -1;

    int max = arr[0];            // save root

    arr[0] = arr[size - 1];     // put last at root
    size--;                      // remove last

    bubbleDown(0);               // fix heap

    return max;
  }

  // Print heap array
  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }


  public void buildHeap(int[] input) {
    // copy input to arr
    arr = input;
    size = input.length;

    // start from last non-leaf → go to root
    int lastNonLeaf = (size / 2) - 1;

    for (int i = lastNonLeaf; i >= 0; i--) {
      bubbleDown(i);           // same bubbleDown we wrote before!
    }
  }

  public static void main(String[] args) {
    MaxHeap heap = new MaxHeap(10);
    heap.insert(10);
    heap.insert(20);
    heap.insert(35);
    heap.insert(30);
    heap.insert(40);

    heap.print();
    //this will bubble up to the root
    heap.insert(55);
    heap.print();

    // buuble down and extract
    System.out.println("Extracted: " + heap.extractMax()); // 40
    heap.print();
    // Output: 35 30 20 10

    // build from unsorted array
    MaxHeap heap1 = new MaxHeap(10);

    int[] input = {3, 9, 2, 1, 4, 5};
    heap1.buildHeap(input);

    heap1.print();
    // Output: 9 4 5 1 3 2
  }
}
