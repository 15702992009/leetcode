package leetcode.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname _0039
 * @Description TODO ：待改进
 * @Date 2020/2/12 0:26
 * @Created by JB 博哥歪，博哥牛批
 */
public class _0039 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null && candidates.length == 0) return ans;
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            int temp = fdp(candidates, candidates[i], target);
            if (temp > target) break;
        }
        return ans;
    }

    public int fdp(int[] candidates, int sum, int target) {
        if (sum > target) ;
        else if (sum == target) {
            List<Integer> tem_list = new ArrayList<Integer>(list);
            Collections.sort(tem_list);
            if (!ans.contains(tem_list)) {
                // ans.add(list); 错误写法，因为这样是浅拷贝
                ans.add(new ArrayList<>(list));
            }
        } else {
            for (int i = 0; i < candidates.length; i++) {
                list.add(candidates[i]);
                int tmp = fdp(candidates, sum + candidates[i], target);
                if (tmp >= target) {
                    break;
                }
            }
        }
        list.remove(list.size() - 1);
        return sum;
    }

    public static void main(String[] args) {
        _0039 l = new _0039();
        l.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

}
