/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy;
        
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else if(l1 == null && l2 == null) return null;
        
        if(l1.val <= l2. val){
            dummy = l1;
            dummy.next = mergeTwoLists(l1.next, l2);
        }else{
            dummy = l2;
            dummy.next = mergeTwoLists(l1, l2.next);
        }
        
        return dummy;
    }
}
