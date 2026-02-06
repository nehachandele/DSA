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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode(-1);
        ListNode ans=res;
        ListNode ptr1=list1;
        ListNode ptr2=list2;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val<ptr2.val){
                res.next=ptr1;
                ptr1=ptr1.next;
            }else{
                res.next=ptr2;
                ptr2=ptr2.next;
            }
            res=res.next;
        }
        if(ptr1==null){
            res.next=ptr2;
        }else{
            res.next=ptr1;
        }
        return ans.next;
    }
}