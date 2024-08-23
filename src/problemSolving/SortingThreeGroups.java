package problemSolving;

import java.util.List;

public class SortingThreeGroups {

    public int minimumOperations(List<Integer> A) {
        int n = A.size(), dp[] = new int[]{n, n, n, n};
        for (int a : A) {
            dp[a]--;
            dp[2] = Math.min(dp[2], dp[1]);
            dp[3] = Math.min(dp[3], dp[2]);
        }
        return dp[3];
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2,1,3,2,1);
        SortingThreeGroups sortingThreeGroups = new SortingThreeGroups();
        int res = sortingThreeGroups.minimumOperations(list);
    }
}
