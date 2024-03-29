package medium;

public class SwapNodesInPairs {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;         // first node
            ListNode node2 = temp.next.next;    // second node
            
            // link the previous part of the list (or the dummy node in the first iteration)
            // to the second node of the current pair (the first node of the pair after swapping)
            temp.next = node2;

            // swap nodes
            node1.next = node2.next;
            node2.next = node1;

            // set temp for the next group of nodes
            temp = node1;
        }

        return pre.next;
    }

    private ListNode swapPairsRecursive(ListNode head) {
        // stop when there is no node or only one node
        if (head == null || head.next == null) {
            return head;
        }

        // keep the second node
        ListNode second = head.next;
        // the first node will point to the rest of the list
        head.next = swapPairsRecursive(second.next);
        // the swapped second becomes the first node, so point to the original head
        second.next = head;
        // return the current first node
        return second;
    }

    public static void main(String[] args) {
        
    }
}
