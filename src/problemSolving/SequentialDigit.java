package problemSolving;

import java.util.*;

public class SequentialDigit {

    public List<Integer> sequentialDigits(int low, int high) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < nums.length - 1) {
            int curr = nums[i];
            while (curr <= high) {
                if (low <= curr && curr <= high)
                    ans.add(curr);
                int rem = curr % 10;
                if (rem == 9)
                    break;
                curr *= 10;
                curr += rem + 1;
            }
            i++;
        }
        Collections.sort(ans);
        return ans;
    }

    public static int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = map.containsKey(1) ? map.get(1) % 2 == 0 ?
                map.get(1) - 1 : map.get(1) : 1;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int val = nums[i];
            while (map.containsKey(val) && map.get(val) >= 2 && val != 1) {
                count += 2;
                val *= val;
            }

            if (map.containsKey(val)) {
                count++;
            } else {
                count--;
            }

            max = Math.max(max, count);
        }
        return max;
    }

    int sum(int[] arr, int i, int n) {
        int sum = Integer.MIN_VALUE;
        int j = i;
        for (; i <= n; i++) {
            sum = Math.max(sum, arr[i]);
        }
        return sum * (n - j + 1);
    }

    public int maxSum(int[] arr, int k, int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        if (k >= n + 1) {
            dp[n] = sum(arr, 0, n);
            return dp[n];
        }
        int max = Integer.MIN_VALUE;
        int len = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (n < k) break;
            max = Math.max(max, arr[n - i]);
            ans = Math.max(ans, (i + 1) * max +
                    maxSum(arr, k, n - i - 1, dp));
            dp[n] = ans;

        }
        return ans;

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int max = maxSum(arr, k, arr.length - 1, dp);
        return max;
    }

    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        int n = t.length();

        for (char c : t.toCharArray()) {
            arr[c]++;
        }

        int start = 0;
        int len = Integer.MAX_VALUE;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c1 = s.charAt(right);
            arr[c1]--;

            if (arr[c1] >= 0) {
                n--;
            }

            while (n == 0) {
                char c2 = s.charAt(left);
                arr[c2]++;

                if (arr[c2] > 0) {
                    if (len > right - left + 1) {
                        len = right - left + 1;
                        start = left;
                    }

                    n++;
                }

                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        final int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int[] sizeEndsAt = new int[n];

        int[] prevIndex = new int[n];
        int maxSize = 0;
        int index = -1;

        Arrays.fill(sizeEndsAt, 1);
        Arrays.fill(prevIndex, -1);
        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j)
                if (nums[i] % nums[j] == 0 &&
                        sizeEndsAt[i] < sizeEndsAt[j] + 1) {
                    sizeEndsAt[i] = sizeEndsAt[j] + 1;
                    prevIndex[i] = j;
                }

            if (maxSize < sizeEndsAt[i]) {
                maxSize = sizeEndsAt[i];
                index = i; // Update the best ending index.
            }
        }


        while (index != -1) {
            ans.add(nums[index]);
            index = prevIndex[index];
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer low = 100, high = 300;
        SequentialDigit sequentialDigit = new SequentialDigit();
        List<Integer> ans = sequentialDigit.sequentialDigits(low, high);
        System.out.println(ans);
        int[] nums = {1, 2, 3};
        int res = SequentialDigit.maximumLength(nums);
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int answer = sequentialDigit.maxSumAfterPartitioning(arr, k);
        String s = "ADOBECODEBANC", t = "ABC";
        String length = sequentialDigit.minWindow(s, t);
        int sum = sequentialDigit.numSquares(12);
        List<Integer> answer1 = sequentialDigit.largestDivisibleSubset(nums);
    }
}
