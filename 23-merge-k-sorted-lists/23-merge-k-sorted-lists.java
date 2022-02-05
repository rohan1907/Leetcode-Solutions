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

class compare implements Comparator<ListNode>{
    @Override
    public int compare(ListNode l1, ListNode l2){
        return l1.val - l2.val;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new compare());
        
        for(ListNode li : lists){
            ListNode head = li;
            while(head!=null){
                pq.offer(head);
                head = head.next;
            }
        }
        if(pq.size() == 0) return null;
        ListNode ans = pq.poll(), head = ans;
        while(!pq.isEmpty()){
            ans.next = pq.poll();
            //System.out.print(ans.val+" ");
            ans = ans.next;
        }
        if(ans.next!=null) ans.next = null;
        return head;
    }
}