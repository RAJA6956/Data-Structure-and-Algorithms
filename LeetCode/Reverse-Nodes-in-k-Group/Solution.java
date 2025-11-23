class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if there are >= k nodes
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;  // not enough nodes
            node = node.next;
        }

        // Step 2: Reverse first k nodes
        ListNode newHead = reverse(head, k);

        // Step 3: Recursively process the rest
        head.next = reverseKGroup(node, k);

        return newHead;
    }

    // Reverse first k nodes starting at head
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head after reversing
    }
}
