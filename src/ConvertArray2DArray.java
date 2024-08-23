import java.util.*;

public class ConvertArray2DArray {

    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }

    public int minOperations(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 != 0 && m.getValue() % 3 != 0) {
                return -1;
            }
            count += m.getValue() / 2;
        }
        return count;
    }

    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n];

        int max = 0;
        for (int num : a) {
            int i = Arrays.binarySearch(dp, 0, max, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == max) max++;

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 2, 3, 1};
        ConvertArray2DArray convertArray2DArray = new ConvertArray2DArray();
        List<List<Integer>> list = convertArray2DArray.findMatrix(arr);
        int[] array = {2, 3, 3, 2, 2, 4, 2, 3, 4};
        int ans = convertArray2DArray.minOperations(array);
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = convertArray2DArray.lengthOfLIS(a);
    }
}
