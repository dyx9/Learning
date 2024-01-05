package easy;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // https://leetcode.cn/problems/reverse-linked-list/solutions/2361282/206-fan-zhuan-lian-biao-shuang-zhi-zhen-r1jel/?envType=study-plan-v2&envId=top-100-liked

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode temp = cur.next;   // store the next node
            cur.next = prev;            // current node should point to prev
            prev = cur;                 // prev node becomes current
            cur = temp;                 // proceed next node
        }

        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        return recur(head, null);
    }
    
    private static ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; 
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode res = reverseListRecursive(head);

        // print reversed results
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    
}
