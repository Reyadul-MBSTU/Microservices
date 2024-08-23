package ApnaCollege;

import java.util.ArrayList;

public class MatchingSubArray {

    public int countMatchingSubArrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int count = 0;
        for (int i = 0; i <= n - m - 1; i++) {
            int k = 0;
            while (k < m) {
                if (nums[i + k + 1] > nums[i + k] && pattern[k] == 1) {
                    k++;
                } else if (nums[i + k + 1] == nums[i + k] && pattern[k] == 0) {
                    k++;
                } else if (nums[i + k + 1] < nums[i + k] && pattern[k] == -1) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == m) {
                count++;
            }
        }
        return count;
    }

    private String spaceRemove(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                continue;
            }
            stringBuilder.append(text.charAt(i));
        }
        return stringBuilder.toString().toLowerCase();
    }

    //TC = O(n)
//Sc = O(n)

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Initialize an ArrayList to hold the merged intervals
        ArrayList<int[]> ans = new ArrayList<>();
        // Initialize a variable to track our position in the input intervals array
        int idx = 0;
        // Loop through the input intervals
        while (idx < intervals.length) {
            // If the current interval starts before the new interval, add it to the answer list
            if (intervals[idx][0] < newInterval[0]) {
                ans.add(intervals[idx]);
                idx++;
                // If the current interval starts after or at the same time as the new interval, exit the loop
            } else {
                break;
            }
        }
        // If the answer list is empty or the last interval in the answer list ends before the new interval starts
        // add the new interval to the answer list
        if (ans.size() == 0 || (newInterval[0] > ans.get(ans.size() - 1)[1])) {
            ans.add(newInterval);
            // If the last interval in the answer list overlaps with the new interval, merge them by updating the end time of the last interval
        } else {
            int[] lastInterval = ans.get(ans.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }
        // Loop through the remaining intervals in the input array
        while (idx < intervals.length) {
            int[] lastInterval = ans.get(ans.size() - 1);
            // If the last interval in the answer list overlaps with the current interval, merge them by updating the end time of the last interval
            if (lastInterval[1] >= intervals[idx][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]);
            } else {
                // If the last interval does not overlap with the current interval, add it to the answer list
                ans.add(intervals[idx]);
            }
            idx++;
        }
        // Convert the ArrayList to a 2D int array and return it
        return ans.toArray(new int[ans.size()][]);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6}, pattern = {1, 1};
        MatchingSubArray matchingSubArray = new MatchingSubArray();
        int ans = matchingSubArray.countMatchingSubArrays(nums, pattern);
        String text = "I am a Student";
        String str = matchingSubArray.spaceRemove(text);
        System.out.println(str);
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = matchingSubArray.insert(intervals, newInterval);
    }
}
