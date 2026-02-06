
 //Definition for singly-linked list.
 import java.util.*;
 
 public class ListNode {
     int val;
     ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/*class Solution {
     int n;
    public ListNode reverseKGroup(ListNode head, int k) {
        n=k;
        return reverse(head,head,k);
    }
    public ListNode reverse(ListNode head, ListNode cur,int k){
        if(cur==null){
            return null;
        }
         // Found the k-th node (becomes new head of this group)
         if(k==1){
            // Process the next group recursively
            ListNode next=reverse(cur.next,cur.next,n);
            if(next==null){
                //Next group is incomplete , keep original order
                head.next=cur.next;
            }else{
                //Connect this group to the next revered group
                head.next=next;
            }
            return cur;

         }else{
            //still counting down to find k-th node
             // CRITICAL: Save original next before recursion
             ListNode temp=cur.next;
             ListNode next=reverse(head,cur.next,k-1);
              // If not enough nodes for a complete group, return null
            if (next == null)
                return null;
            
            // Reverse the link: make next node point back to current
            temp.next = cur;
            
            // Propagate the new head up the recursion chain
            return next;

         }
    }
}*/

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
     int n;
    public ListNode reverseKGroup(ListNode head, int k) {
        n=k;
        return reverse(head,head,k);
    }
    public ListNode reverse(ListNode head, ListNode cur,int k){
        if(cur==null){
            return null;
        }
         // Found the k-th node (becomes new head of this group)
         if(k==1){
            // Process the next group recursively
            ListNode next=reverse(cur.next,cur.next,n);
            if(next==null){
                //Next group is incomplete , keep original order
                head.next=cur.next;
            }else{
                //Connect this group to the next revered group
                head.next=next;
            }
            return cur;

         }else{
            //still counting down to find k-th node
             // CRITICAL: Save original next before recursion
             ListNode temp=cur.next;
             ListNode next=reverse(head,cur.next,k-1);
              // If not enough nodes for a complete group, return null
            if (next == null)
                return null;
            
            // Reverse the link: make next node point back to current
            temp.next = cur;
            
            // Propagate the new head up the recursion chain
            return next;

         }
    }
}*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kth = getKth(prevGroupEnd, k);
            if (kth == null) break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // reverse group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
