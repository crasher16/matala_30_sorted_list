package ex1;
import unit4.collectionsLib.Node;

public class matala_30_sorted_list {

    // Exercise 30: Check if list is sorted in ascending order
    // Input: head of linked list of integers
	// By: Idan Dror

    public static boolean isSortedAscending(Node<Integer> h) {

        // Empty list or single element list
        if (h == null || h.getNext() == null)
            return true;

        Node<Integer> current = h;

        // Scan the list
        while (current.getNext() != null) {
            if (current.getValue() > current.getNext().getValue())
                return false;

            current = current.getNext();
        }

        return true;
    }

    // ---------- helper methods ----------

    public static void printList(Node<Integer> h) {
        Node<Integer> tmp = h;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print(tmp.getValue() + " ");

        System.out.println();
    }

    public static Node<Integer> createList(int[] arr) {
        Node<Integer> head = null;
        Node<Integer> tmp = null;

        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new Node<Integer>(arr[i]);
                tmp = head;
            } else {
                tmp.setNext(new Node<Integer>(arr[i]));
                tmp = tmp.getNext();
            }
        }
        return head;
    }

    // -------------------- main tests --------------------

    public static void main(String[] args) {

        // Test 1: sorted list
        Node<Integer> h1 = createList(new int[]{1, 2, 3, 4, 5});
        printList(h1);
        System.out.println("Result: " + isSortedAscending(h1));
        System.out.println();

        // Test 2: not sorted
        Node<Integer> h2 = createList(new int[]{1, 3, 2, 5});
        printList(h2);
        System.out.println("Result: " + isSortedAscending(h2));
        System.out.println();

        // Test 3: single element
        Node<Integer> h3 = createList(new int[]{7});
        printList(h3);
        System.out.println("Result: " + isSortedAscending(h3));
        System.out.println();

        // Test 4: empty list
        Node<Integer> h4 = null;
        printList(h4);
        System.out.println("Result: " + isSortedAscending(h4));
    }
}

