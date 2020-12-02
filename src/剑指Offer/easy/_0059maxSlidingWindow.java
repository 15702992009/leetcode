package 剑指Offer.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *   下面是错的答案，保存下来下次思考问题出在哪里
 *
 *
 *
 */
public class _0059maxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int sizeWindows = k;
            if (nums.length == 0 && k < 0) return new int[0];
            int[] res = new int[sizeWindows];
            //lastElement contains the sum of deque values
            Deque<Integer> deque = new LinkedList<>();
            deque.addLast(0);
            int max = 0, index = 0;
            for (int i = 0; i < nums.length; i++, k--) {
                //sum the first k elements []
                if (k > 0) {
                    max += nums[i];
                    index = 0;
                } else {
                    if (nums[i]<0) {
                        Integer sum = deque.removeLast();
                        deque.addLast(nums[i]);
                        deque.addLast(nums[i] + sum);
                        continue;
                    }

                    int tmp = max - nums[index] + deque.peekLast();
                    if (tmp > max) {
                        int size = deque.size();
                        while (size > 0) {
                            index++;
                            size--;
                        }
                        deque.clear();
                    } else {
                        Integer sum = deque.removeLast();
                        deque.addLast(nums[i]);
                        deque.addLast(nums[i] + sum);
                    }

                }
            }

            int i = 0;
            while (i < sizeWindows) {
                res[i++] = nums[index++];
            }
            return res;
        }
    }
}
