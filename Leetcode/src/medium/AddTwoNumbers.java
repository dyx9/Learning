package medium;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // a dummy pointer used to return the head of a linked list (result)
        ListNode pre = new ListNode(0);
        
        // the pointer used to create the a new node that store sum of two digits
        ListNode cur = pre;
        
        // record carry if any
        int carry = 0;
        
        // 
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            // calculate sum
            int sum = x + y + carry;

            // carry = 1 if sum >= 10, carry = 0 if sum < 10
            carry = sum / 10;

            // store the result as a new node
            cur.next = new ListNode(sum % 10);

            // move the pointer
            cur = cur.next;

            // move to next digit if any
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        // if the last operation has carry
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }

        // return the head of the result
        return pre.next;
    }

}
