package leetcode.Linklist;

import java.util.HashSet;
import java.util.Set;

public class _0141LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        /**
         * HashSet
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            Set hashSet = new HashSet<ListNode>();
            while (head != null) {
                if (!hashSet.add(head)) return true;
                head = head.next;
            }
            return false;
        }

        /**
         * double pointer fast/slow
         * @param head
         * @return
         */
        public boolean hasCycle2(ListNode head) {
            if (head==null) return false;
            ListNode fast =head.next,slow =head;
            while (fast!=slow){
                if (fast==null||fast.next==null) return false;
                fast=fast.next.next;
                slow=slow.next;
            }
            return  true;

        }

    }
}
