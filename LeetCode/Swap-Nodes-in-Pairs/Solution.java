/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode head1=new ListNode(0);
        head1.next=head;
        ListNode prev=head1;
        return swap(head,prev,head1);
        
    }
    
    public ListNode swap(ListNode head,ListNode prev,ListNode head1){
        if(head==null || head.next==null){
            return head1.next;

        }
        ListNode first=head;
        ListNode second=head.next;
        //swap
        first.next=second.next;
        second.next=first;
        prev.next=second;
        //
        prev=first;
        head=head.next;
        return swap(head,prev,head1);


    }
}