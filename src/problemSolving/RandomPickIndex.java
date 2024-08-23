package problemSolving;

import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> map;
    static Random random = new Random();

    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> ids = new ArrayList<>();
                ids.add(i);
                map.put(key, ids);
            }
        }
    }

    public int pick(int target) {
        List<Integer> ids = map.get(target);
        return ids.get(random.nextInt(ids.size()));
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<word1.length(); i++)
        {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0)+1);
            map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i), 0)-1);
        }
        for(int value:map.values())
        {
            if(value<-3||value>3)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3};
        RandomPickIndex randomPickIndex = new RandomPickIndex(arr);
        int res = randomPickIndex.pick(3);
        String  word1 = "aaaa", word2 = "bccb";
        boolean bool = randomPickIndex.checkAlmostEquivalent(word1, word2);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

