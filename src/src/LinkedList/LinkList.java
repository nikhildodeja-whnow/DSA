package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkList {
    Node head; // instance field

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;              // ✅ stop here, nothing more to do
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Node insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 4. Search
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) return true;
            current = current.next;
        }
        return false;
    }

    // 5. Delete by value
    public void delete(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while(current!=null) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current=nextTemp;
        }
        return prev;
    }

    public int findNthElement(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++ ) {
            fast = fast.next;
        }
        while (fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public boolean isLinkSorted(Node head) {
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                break;
            }
            int currentValue = current.data;
            int nextValue = current.next.data;
            if (currentValue > nextValue) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void removeDuplicate(Node head) {
        Node current = head;
        while (current != null) {
            if (current.next == null) break;
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public boolean doesCycleExists(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public boolean isPalindrome(Node head) {
        if (head == null  || head.next == null) {
            return true;
        }
        // find middle
        Node middle = findMiddle(head);
        // reverse second list from the middle
        Node right = reverseList(middle);
        // Compare first and second half
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();   // ✅ create an object first
        int[] nums = {10, 20, 30, 30, 40, 50, 60, 70, 80, 90, 100};
        for (int num : nums) {
            list.insertAtEnd(num);        // ✅ call on the object
        }
        list.printList();  // 10 -> 20 -> 30 -> 40 -> 50 -> null
        System.out.println(list.search(10));
//        list.delete(50);
        list.printList();
//        list.head = list.reverseList(list.head);
        list.printList();
        System.out.println("Finding middle =>" + list.findMiddle(list.head).data);
        System.out.println("Finding nth Element => " + list.findNthElement(list.head, 4));
        System.out.println("Is Link Sorted ===>" + list.isLinkSorted(list.head));
        System.out.print("Remove DUplicate");
        list.removeDuplicate(list.head);
        System.out.println("Printing after remove duplicate");
        list.printList();
        // check cycle is there or not
        LinkList cycle = new LinkList();
        int[] nums1 = {10, 20, 30, 40, 50};
        Node cycleToPoint = null;
        Node cyclePointer = null;
        Node temp;
        for (int num : nums1) {
            temp = cycle.insertAtLast(num);
            if (num == 30) {
                cycleToPoint = temp;
            } else if (num == 50) {
                cyclePointer = temp;
            }
        }
        cyclePointer.next = cycleToPoint;
        System.out.println("Does Cylce Exists =>" + cycle.doesCycleExists(cycle.head));

        LinkList palindromList = new LinkList();
        int[] palindroms = {10, 20, 30, 10 ,20};
        for (int num : palindroms) {
            palindromList.insertAtEnd(num);
        }
        System.out.println("Is List Palindrom => " + palindromList.isPalindrome(palindromList.head));
    }
}