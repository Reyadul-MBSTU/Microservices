package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            List<List<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < result.get(j).size() + 1; k++) {
                    List<Integer> currList = new ArrayList<>(result.get(j));
                    currList.add(k, currValue);
                    temp.add(currList);
                }
            }
            result = temp;
        }
        return result;
    }*/


        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(new ArrayList<>(), ans, nums);
            return ans;
        }

        public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
            if (curr.size() == nums.length) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int num: nums) {
                if (!curr.contains(num)) {
                    curr.add(num);
                    backtrack(curr, ans, nums);
                    curr.remove(curr.size() - 1);
                }
            }
        }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permutations.permute(nums);
        Arrays.sort(nums);
        System.out.println(permute);
    }
}

