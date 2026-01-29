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
    public int length(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        ListNode prev=null;
        int len=length(temp);
        if(n==1 && len==1) return null;
        int front=len-n+1;
        int i=1;
        while(i!=front && temp!=null){
            prev=temp;
            temp=temp.next;
            i++;
        }
        if(front==1) return head.next;
        if(prev!=null){
            prev.next=temp.next;
        }
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
