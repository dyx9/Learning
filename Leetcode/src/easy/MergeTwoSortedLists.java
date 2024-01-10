package easy;

import java.util.LinkedList;

/**
 * merge two sorted (same sorting order) lists in-place
 * input: head of each list
 * return: the head of the merged list
 */
class MergeTwoSortedLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // O(n+m) time, O(1) space
    static ListNode mergeIteratively(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0);       // track current sorted node
        ListNode head = dummyNode;                      // a node used to return the head after sorting

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummyNode.next = l1;
                l1 = l1.next;
            }
            else {
                dummyNode.next = l2;
                l2 = l2.next;
            }
            dummyNode = dummyNode.next;
        }

        // when one of the list exhausts, append the rest of the other list to the current sorted node
        dummyNode.next = l1 == null ? l2 : l1;
        return head.next;
    }


    // O(n+m) time, O(n+m) space
    private ListNode mergeTwoSortedListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoSortedListsRecursive(l1.next, l2);
            return l1;
        }
        else l2.next = mergeTwoSortedListsRecursive(l1 ,l2.next);
        return l2;
    }

    static private void printList(ListNode node) {
        LinkedList<Integer> results = new LinkedList<>();
        while (node != null) {
            results.add(node.val);
            node = node.next;
        }
        System.out.println(results);
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        printList(mergeIteratively(l1, l2));

    }

}
