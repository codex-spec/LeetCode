// 24. Swap Nodes in Pairs
// Given a linked list, swap every two adjacent nodes and return its head. 
// You must solve the problem without modifying the values in the list's nodes 
// (i.e., only nodes themselves may be changed.)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(head == NULL || head -> next == NULL) 
        {
            return head;
        }
            
        ListNode* temp; // temporary pointer to store head -> next
        temp = head->next; // give temp what he want
        
        head->next = swapPairs(head->next->next); // changing links
        temp->next = head; // put temp -> next to head
        
        return temp; // now after changing links, temp act as our head
    }
};