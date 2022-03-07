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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        ListNode temp1=l1, temp2=l2;
        while(temp1!=null && temp2!=null){
            if(temp1.val>temp2.val){
                pointer.next = temp2;
                pointer = pointer.next;
                temp2 = temp2.next;
            }
            else{
                pointer.next = temp1;
                pointer = pointer.next;
                temp1 = temp1.next;
            }
        }
        if (temp1!=null) pointer.next = temp1;
        if(temp2!=null) pointer.next = temp2;
        return dummy.next;
    }
}