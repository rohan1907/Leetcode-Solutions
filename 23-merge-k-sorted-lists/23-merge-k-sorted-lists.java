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
    public ListNode mergeKLists(ListNode[] lists) {
          return partition(lists, 0, lists.length-1);
    }
    
    public ListNode partition(ListNode[] lists, int i, int j){
        while(i==j){
            return lists[i];
        }
        if(i<j){
            int mid = i + (j-i)/2;
            ListNode l1 = partition(lists, i, mid);
            ListNode l2 = partition(lists, mid+1, j);
            
            return sort(l1, l2);
        }
        else {
            return null;
        }        
    }
    
    public ListNode sort(ListNode l1, ListNode l2){
        ListNode head= new ListNode(0);
        ListNode dummy = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else if(l2.val<l1.val){
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l1!=null){
            dummy.next = l1;
        }
        if(l2!=null){
            dummy.next = l2;
        }
        return head.next;
    }
}