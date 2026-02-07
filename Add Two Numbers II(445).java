
//3ms
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2=new Stack<Integer>();

        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int sum=0;
        ListNode list=new ListNode(0);
        while(!s1.empty()||!s2.empty()){
            if(!s1.empty()) sum+=s1.pop();
            if(!s2.empty()) sum+=s2.pop();
            list.val=sum%10;
            ListNode head=new ListNode(sum/10);
            head.next=list;
            list=head;
            sum/=10;
        }
        return list.val==0?list.next:list;
    }
}
/* 
//2ms
class Solution {
    private ListNode reverse(ListNode l){
        ListNode prev = null;
        ListNode curr = l;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode dummy = new ListNode();
        int carry =0;
        while(r1 !=null || r2 !=null){
            int num1 = r1 !=null?r1.val:0;
            int num2 = r2 !=null?r2.val:0;
            int total = num1+num2+carry;
            carry = total/10;
            dummy.val= total%10;
            ListNode carrNode = new ListNode(carry);
            carrNode.next = dummy;
            dummy = carrNode;
            r1= r1!=null?r1.next:r1;
            r2= r2!=null?r2.next:r2;
        }
        return carry ==0?dummy.next:dummy;
    }
}

*/