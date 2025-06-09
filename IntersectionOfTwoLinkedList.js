class ListNode {
    constructor(x) {
        this.val = x;
        this.next = null;
    }
}

class Solution {
    getIntersectionNode(headA, headB) {
        let cur = headA;
        let curO = headB;

        while (cur !== curO) {
            cur = cur === null ? headB : cur.next;
            curO = curO === null ? headA : curO.next;
        }

        return cur;
    }
}

