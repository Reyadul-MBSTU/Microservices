package problemSolving;

import java.util.HashMap;

public class LongestSubString {

    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int ans = 0;
        for (int end = 0; end < nums.length; end++) {
            int v = nums[end];

            map.put(v, map.getOrDefault(v, 0) + 1);

            while (map.containsKey(v) && map.get(v) > k) {
                int val = nums[start];

                if (map.get(val) == 1) map.remove(val);
                else
                    map.put(val, map.getOrDefault(val, 0)-1);

                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;


    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        LongestSubString longestSubString = new LongestSubString();
        longestSubString.maxSubarrayLength(nums, k);
    }
}

