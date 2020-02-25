package leetcode.Array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, ans, new ArrayList<Integer>());
        return ans;
    }

    public boolean backtrack(int[] arr, int tg, int start, List<List<Integer>> ans, List<Integer> tmp) {
        if (tg<0) return true;
        if (tg==0) ans.add(new ArrayList<>(tmp));
        for(int i=start;i<arr.length;i++)
        {
            tmp.add(arr[i]);
            boolean stop = backtrack(arr, tg-arr[i], i, ans, tmp);
            tmp.remove(tmp.size()-1);
            if (stop==true) break;
        }
        return false;
    }
}
