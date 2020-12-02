package swordToOffer;

public class _0022 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            int count=k;
            ListNode fast =head, slow =head ;

            for(int i=0;i<k;i++)
                fast=fast.next;
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
    }
}
