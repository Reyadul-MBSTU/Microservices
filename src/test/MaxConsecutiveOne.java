package test;

public class MaxConsecutiveOne {

    public int longestOnes(int[] A, int K) {
        int zeroCount = 0, start = 0, res = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) zeroCount++;
            while (zeroCount > K) {
                if (A[start] == 0) zeroCount--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
     int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
     int k = 2;
     MaxConsecutiveOne maxConsecutiveOne = new MaxConsecutiveOne();
     int res = maxConsecutiveOne.longestOnes(nums,k);

    }
}
