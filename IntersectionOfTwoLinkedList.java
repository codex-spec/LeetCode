/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode cur = headA;
    ListNode curO = headB;
    
    while( cur != curO){
        cur = cur == null? headB : cur.next;
        curO = curO == null? headA : curO.next;    
    }
    
    return cur;

    }
}
