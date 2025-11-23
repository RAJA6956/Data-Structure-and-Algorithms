public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Step 1: Count the total number of nodes
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Reverse in groups of k
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        current = head;

        while (length >= k) {
            ListNode groupStart = current;
            ListNode prev = null;
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            prevGroupEnd.next = prev;
            groupStart.next = current;
            prevGroupEnd = groupStart;
            length -= k;
        }

        return dummy.next;
    }
}
