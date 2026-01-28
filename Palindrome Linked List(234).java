/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int left=0;
        int right=list.size()-1;
        while(left<right && list.get(left)==list.get(right)){
            left++;
            right--;
        }
        return left>=right;
    }
}
    */


// Definition for singly-linked list.
import java.util.*;


class Solution {
     public class ListNode {
     int val;
    ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // if(fast != null)
        //     slow = slow.next;
        
        // System.out.println(slow.val);
        slow = reverse(slow);
        // System.out.println(slow.val);
        
        while(slow != null){
            if(slow.val != head.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        
        return head == null || head.next == null;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode n = head.next;
            head.next = prev;
            prev = head;
            head = n;
        }
        return prev;
    }
}