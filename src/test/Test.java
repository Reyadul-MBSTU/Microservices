package test;

import java.util.HashSet;

public class Test {

    public int longestSemiRepetitiveSubstring(String s) {
        int i = 0, cur = 0, n = s.length();
        for (int j = 1; j < n; ++j) {
            cur += s.charAt(j) == s.charAt(j - 1) ? 1 : 0;
            if (cur > 1) {
                cur -= s.charAt(++i) == s.charAt(i - 1) ? 1 : 0;
            }
        }
        return n - i;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int elem : nums) {
            set.add(elem);
        }
        int max = 0;
        for (int elem : nums) {
            // Trying to find the minimum elem of the longest consecutive sequence
            if (!set.contains(elem - 1)) {
                int count = 1;
                while (set.contains(elem + 1)) {
                    count += 1;
                    elem += 1;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "52233";
        Test test = new Test();
        int ans = test.longestSemiRepetitiveSubstring(s);
        System.out.println(ans);

        int[] nums = {100,4,200,1,3,2};
        int max = test.longestConsecutive(nums);
    }
}
