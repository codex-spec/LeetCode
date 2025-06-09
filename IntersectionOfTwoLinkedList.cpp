#include <iostream>

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
        ListNode* cur = headA;
        ListNode* curO = headB;

        while (cur != curO) {
            cur = cur == nullptr ? headB : cur->next;
            curO = curO == nullptr ? headA : curO->next;
        }

        return cur;
    }
};

