package leetcode.swordToOffer;

import java.util.*;

public class _0040 {

    class Solution_official1 {
        /**
         * 复杂度分析
         * <p>
         * 时间复杂度：O(n\log n)O(nlogn)，其中 nn 是数组 arr 的长度。算法的时间复杂度即排序的时间复杂度。
         * <p>
         * 空间复杂度：O(\log n)O(logn)，排序所需额外的空间复杂度为 O(\log n)O(logn)。
         *
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] vec = new int[k];
            Arrays.sort(arr);
            for (int i = 0; i < k; ++i) {
                vec[i] = arr[i];
            }
            return vec;
        }

    }

    /**
     * heap
     */
    class Solution_priorityQueue {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] vec = new int[k];
            if (k == 0) { // 排除 0 的情况
                return vec;
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>(k, (l, r) -> r - l);


            for (int value : arr) {
                if (heap.isEmpty() || heap.size() < k || value < heap.peek())
                    heap.offer(value);
                if (heap.size() > k) heap.poll();
            }

            int i = 0;
            for (Integer integer : heap) {
                vec[i++] = integer;
            }
            return vec;
        }
    }

    /**
     * quick sort to solve max k or min k
     */
    class Solution_quickSortSolution {

        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 最后一个参数表示我们要找的是下标为k-1的数
            return quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        private int[] quickSearch(int[] nums, int lo, int hi, int k) {
            // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
            int j = partition(nums, lo, hi);
            if (j == k) {
                return Arrays.copyOf(nums, j + 1);
            }
            // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
            return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
        }

        // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];
            int i = lo, j = hi + 1;
            while (true) {
                while (++i <= hi && nums[i] < v) ;
                while (--j >= lo && nums[j] > v) ;
                if (i >= j) {
                    break;
                }
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            nums[lo] = nums[j];
            nums[j] = v;
            return j;
        }
    }


    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            List<Integer> list1 = new ArrayList<Integer>();
            for (int i : arr) {
                list1.add(i);
            }
            Collections.sort(list1);
            List<Integer> list = list1.subList(0, k);
            int[] ret = new int[list.size()];
            for (int i = 0; i < ret.length; i++)
                ret[i] = list.get(i);
            return ret;
        }
    }


    /**
     * How to convert List<Integer> to int[] in Java? [duplicate]
     */

    public int[] listToArray(List<Integer> list) {
        int[] arrays = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrays[i] = list.get(i);
        }
        return arrays;
    }

    public void ConvertArrayListToArray() {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        Integer[] intArray = new Integer[intList.size()];
        intArray = intList.toArray(intArray);

        for (Integer i : intArray)
            System.out.println(i);
    }

}
