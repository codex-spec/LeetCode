
  //Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 


 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         
        ListNode h = new ListNode();
        ListNode re = h;
        int c = 0;
        
        while(l1!=null || l2!=null || c!=0){
            
            int s = 0;
            
            if(l1!=null){
                s+=l1.val;
                l1 = l1.next;
            }
            
            if(l2!=null){
                s+=l2.val;
                l2 = l2.next;
            }
            
            s+=c;
            
            int v = s%10;
            c = s/10;
            
            ListNode tN = new ListNode();
            tN.val = v;
            
            h.next = tN;
            h = tN;          
        }
       
        return re.next;  
  }

}
        
        
