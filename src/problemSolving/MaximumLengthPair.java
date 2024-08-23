package problemSolving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumLengthPair {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int sz = pairs.length, currLen = 1, prevEnd = pairs[0][1];
        for (int indx = 1; indx < sz; indx++) {
            var pr = pairs[indx];
            int currStart = pairs[indx][0];
            if (prevEnd < currStart) {
                currLen++;
                prevEnd = pr[1];
            }
        }
        return currLen;
    }

    public int minimumSum(int n, int k) {
        int sum = 0;
        Map<Integer, Integer> nm = new HashMap<>();
        for (int i = 1; nm.size() < n; i++) {
            if (!nm.containsKey(k - i)) {
                sum += i;
                nm.put(i, 1);
            }
            //System.out.println(nm);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        MaximumLengthPair maximumLengthPair = new MaximumLengthPair();
        int res = maximumLengthPair.findLongestChain(pairs);
        int result = maximumLengthPair.minimumSum(5, 4);
    }
}
