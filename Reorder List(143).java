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

/*class Solution {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        int size=getSize(head);

        ListNode[] nums=new ListNode[size];
        ListNode curr=head;

        for(int i=0;i<size;i++){
            nums[i]=curr;
            curr=curr.next;
        }

        int start=0;
        int last=size-1;

        while(start<last){
            nums[start].next=nums[last];
            start++;

            if(start==last){
                break;
            }
            nums[last].next=nums[start];
            last--;
        }
        nums[last].next=null;
        
    }
    public int getSize(ListNode head){
       int count=0;
       while(head!=null){
        count++;
        head=head.next;
       }
       return count;
    }
}
*/
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        // 1️⃣ Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2️⃣ Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3️⃣ Merge both halves
        ListNode first = head;
        ListNode second = prev;

        while(second != null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
}
