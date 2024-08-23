package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        Arrays.sort(candidates);
        int i = 0;
        int j = candidates.length;

        findCombinations(candidates, target, i, ans, a);

        return ans;

    }

    public void findCombinations(int[] candidates,
                                 int target,
                                 int index,
                                 List<List<Integer>> ans,
                                 List<Integer> a) {

        if (target == 0) {
            ans.add(new ArrayList<Integer>(a));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            if (index != i && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] <= target) {
                a.add(candidates[i]);
                findCombinations(candidates,
                        target - candidates[i], i + 1, ans, a);
                a.remove(new Integer(candidates[i]));
            }
        }


    }

    static void foo(int x) {
        if (x > 0) {
            foo(--x);
        }
        System.out.println(x);
    }


    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int pointer2 = 0, pointer3 = 0, pointer5 = 0;

        for (int i = 1; i < n; i++) {
            int nextUglyNumber = Math.min(uglyNumbers[pointer2] * 2,
                    Math.min(uglyNumbers[pointer3] * 3, uglyNumbers[pointer5] * 5));
            uglyNumbers[i] = nextUglyNumber;

            if (nextUglyNumber == uglyNumbers[pointer2] * 2) {
                pointer2++;
            }
            if (nextUglyNumber == uglyNumbers[pointer3] * 3) {
                pointer3++;
            }
            if (nextUglyNumber == uglyNumbers[pointer5] * 5) {
                pointer5++;
            }
        }

        return uglyNumbers[n - 1];
    }


    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> ans = combinationSumII.combinationSum2(candidates, target);
        foo(10);
        int answer = combinationSumII.nthUglyNumber(10);
    }
}
