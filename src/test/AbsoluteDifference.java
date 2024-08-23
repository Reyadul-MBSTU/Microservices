package test;

import java.util.Arrays;

public class AbsoluteDifference {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length, leftSum = 0, rightSum = Arrays.stream(nums).sum();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = i * nums[i] - leftSum + rightSum - (n - i) * nums[i];
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return res;
    }


    int totalMoney(int n) {
        //ans= sigma(1+2+3+4+5+6+7)+7+14+....+(xi+..+xn).
        if (n <= 7) return n * (n + 1) / 2;
        int x = 28;
        int weeks = n / 7;
        //int f_nth_week=1+weeks;
        int remain = n - weeks * 7;
        int t1 = x * weeks + 7 * (weeks * (weeks - 1)) / 2;
        // 2*(f_nth_week)==1+weeks .
        // Formula for Sum of A.p.=(2*a+(n-1)*d)*n/2;
        int t2 = (2 * weeks + remain + 1) * remain / 2;
        return t1 + t2;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        AbsoluteDifference absoluteDifference = new AbsoluteDifference();
        int[] arr = absoluteDifference.getSumAbsoluteDifferences(nums);

        int sum = absoluteDifference.totalMoney(20);

    }
}
