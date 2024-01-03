package easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }
    
    // hashset time O(m+n) space O(m)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (visited.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    // two pointers
    public ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
