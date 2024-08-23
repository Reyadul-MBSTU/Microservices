import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solution(nums, result, list, nums.length, 0);
        return result;
    }

    private void solution(int[] nums, List<List<Integer>> result, List<Integer> list, int n, int start) {
        result.add(new ArrayList(list));

        for (int i = start; i < n; i++) {
            list.add(nums[i]);
            solution(nums, result, list, n, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public int numSteps(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);

        // All the trailing 0s can be popped by 1 step.
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
            ++ans;
        }

        if (sb.toString().equals("1"))
            return ans;

        // `s` is now odd, so add 1 to `s` and cost 1 step.
        ++ans;

        // All the 1s will become 0s and can be popped by 1 step.
        // All the 0s will become 1s and can be popped by 2 steps (adding 1 then
        // dividing by 2).
        for (final char c : sb.toString().toCharArray())
            ans += c == '1' ? 1 : 2;

        return ans;
    }

    public int numStepsCount(String s) {

        int count = 0;
        int carry = 0;

        for (int i = s.length() - 1; i >= 1; i--) {
            int num = s.charAt(i) - '0';
            if (num == 0 && carry == 0) {
                count++;

            } else if (num == 1 && carry == 1) {
                count++;
                carry = 1;
            } else {
                count += 2;
                carry = 1;
            }
        }
        if (carry == 1)
            count++;

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.subsets(nums);
        System.out.println(ans);
        String input = "1101";
        int count = solution.numSteps(input);
    }
}
