package leetcode.Linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 学会了： ArrayList API :
 * E get(int index);  Returns the element at the specified position in this list.
 * int size();  return size of list
 */
public class _0234 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        /**
         * 将值复制到数组中后用双指针法
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<Integer>();

            ListNode p = head;
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            int front = 0;
            int back = list.size() - 1;
            while (front < back) {
                if (!list.get(front).equals(list.get(back))) return false;

                front++;
                back--;
            }
            return true;
        }

        /**
         * 我们也可以使用快慢指针在一次遍历中找到：慢指针一次走一步，快指针一次走两步，快慢指针同时出发。当快指针移动到链表的末尾时，
         * 慢指针恰好到链表的中间。通过慢指针将链表分为两部分。
         */
        public boolean isPalindrome1(ListNode head) {
            if (head == null) return false;
            ListNode phead = head;
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);
            ListNode p1=head;
            ListNode p2=secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;

        }

        private ListNode reverseList(ListNode head) {
            ListNode prev=null;
            ListNode curr=head;
            while (curr!=null){
                ListNode nextTemp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast =head;
            ListNode slow =head;
            while (fast.next!=null&&fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }
       /* public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }*/
    }

}


