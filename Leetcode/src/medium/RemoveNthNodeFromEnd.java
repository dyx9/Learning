package medium;

public class RemoveNthNodeFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode right = head;
        ListNode pre = new ListNode(0, head);
        ListNode left = pre;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        // pre -> 1 -> 2 -> 3 -> 4 -> 5
        //  ^               ^
        // left           right

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return pre.next;
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        // delete 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        removeNthFromEnd(head, 2);
        
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
