// Merge Two sorted lits 
// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode nL = new ListNode();
        if(list1 == null && list2 == null) return list1;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        
        if(list1.val <= list2.val) {
            nL.val = list1.val;
            nL.next = mergeTwoLists(list1.next, list2);
            //return list1;
        }else {
        nL.val = list2.val;
        nL.next = mergeTwoLists(list1, list2.next);
        }
        
        return nL;
    }
}