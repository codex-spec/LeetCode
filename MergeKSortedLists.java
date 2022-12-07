Merge k sorted Lists 

//You are given an array of k linked-lists lists, 
//each linked-list is sorted in ascending order.
//Merge all the linked-lists into one sorted linked-list and return it.


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
        ListNode preHead = new ListNode();
        ListNode head = preHead;
        List<Integer> currList = new ArrayList<>();
        for(int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while(curr != null) {
                currList.add(curr.val);
                curr = curr.next;
            }
        }

            Collections.sort(currList);
            for(int i = 0; i < currList.size(); i++) {
                preHead.next = new ListNode(currList.get(i));
                preHead = preHead.next;
            }
            return head.next;
            
    }
}
