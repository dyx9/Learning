package easy;

class MergeTwoSortedLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode mergeTwoSortedListsIterative(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }
            else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

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

}
