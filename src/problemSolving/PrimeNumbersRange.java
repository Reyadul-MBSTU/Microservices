package problemSolving;

import java.util.HashMap;
import java.util.Map;

public class PrimeNumbersRange {

    public int[] closestPrimes(int left, int right) {
        Integer[] arr = new Integer[10 ^ 6];
        Map<Integer, Integer[]> map = new HashMap<>();
        int j = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                arr[j++] = i;
            }
            if ((j) % 2 == 0 && j != 0) {
                map.put(arr[j - 1] - arr[j - 2], new Integer[]{arr[j - 2], arr[j - 1]});
            }
        }
        if (!map.isEmpty()) {
            Integer minKey = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer[]> m : map.entrySet()) {
                if (minKey > m.getKey()) {
                    minKey = m.getKey();
                }
            }
            Integer[] array = map.get(minKey);
            return new int[]{array[0], array[1]};
        }
        return new int[]{-1, -1};
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int bestClosingTime(String customers) {
        int maxScore = 0;
        int bestIndex = 0;
        int currentScore = 0;
        for (int i = 0; i < customers.length(); ++i) {
            char customerShowedUp = customers.charAt(i);
            if (customerShowedUp == 'Y') {
                ++currentScore;
            } else {
                --currentScore;
            }
            if (maxScore < currentScore) {
                maxScore = currentScore;
                bestIndex = i + 1;
            }
        }
        return bestIndex;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // Check for empty nums1 or nums2. If any is 0, then there won't be any repeated subarray.
        if (m == 0 || n == 0) {
            return 0;
        }

        // Dynamic Programming using 1D Array.
        int[] dp = new int[n + 1];
        int max = 0;

        // Traverse both nums2 for every numbers in nums1, to check if same number.
        // Method is similar to the 2D Matrix solution, but we only use an array to keep track of the count.
        // Example:
        // nums1 = [1,2,3,4]
        // nums2 = [4,2,3,4]
        // i = 3, dp = [1,0,0,1,0], max = 1
        // i = 2, dp = [0,0,2,0,0], max = 2
        // i = 1, dp = [0,3,0,0,0], max = 3
        // i = 0, dp = [0,0,0,0,0], max = 3
        // Note that the count for each round only increase when there is a continuing match from previous number.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[j] = nums1[i] == nums2[j] ? dp[j + 1] + 1 : 0;
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int left = 19, right = 31;
        PrimeNumbersRange primeNumbersRange = new PrimeNumbersRange();
        int[] result = primeNumbersRange.closestPrimes(left, right);
        String customers = "YYNY";
        int res = primeNumbersRange.bestClosingTime(customers);
        System.out.println(res);
        int[]  nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        int len = primeNumbersRange.findLength(nums1, nums2);
        System.out.println(len);

    }
}

