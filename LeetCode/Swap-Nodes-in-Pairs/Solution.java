public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Base case: if the list is empty or has only one node, no swap needed
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse the list in pairs
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // Swap the nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move pointers for the next pair
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
