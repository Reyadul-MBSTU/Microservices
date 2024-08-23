package test;

public class MaximumValue {
    public int maxValue(int n, int index, int maxSum) {
        int curSum = maxSum;
        curSum -= n; //fill array with 1's
        int res = 1;
        int round = 0;
        while (curSum >= 0) {
            res++;
            curSum -= (1 + Math.min(round, index) + Math.min(round, n - 1 - index)); //each round we need to extend 1 more from left side and right side respectively -- can be proved by induction
            round++;
            if (curSum < 0) { //not enough curSum for this round
                res--;
                break;
            }
            if (round >= index && round >= (n - 1 - index)) { //pruning to speed up, avoid TLE in extreme cases
                res += curSum / n;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4, index = 2, maxSum = 6;
       MaximumValue maximumValue = new MaximumValue();
       int ans = maximumValue.maxValue(n, index, maxSum);
       System.out.println(ans);
    }
}
