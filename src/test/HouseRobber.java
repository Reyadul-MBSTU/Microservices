package test;

public class HouseRobber {

    public int rob(int[] nums) {
        int prev = 0, last = 0;
        for (int curr : nums)
            last = Math.max(prev + curr, prev = last);
        return last;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {1,2,3,1};
        int res = houseRobber.rob(nums);
        System.out.println(res);
    }

}
