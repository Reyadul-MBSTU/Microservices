package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class JobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] dp = new int[len][3];
        for (int i = 0; i < len; i++) {
            dp[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(dp, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (var i : dp) {
            int cur = map.floorEntry(i[0]).getValue() + i[2];
            if (cur > map.lastEntry().getValue()) {
                map.put(i[1], cur);
            }
        }

        return map.lastEntry().getValue();
    }

    //   Bottom Up
    static int helper(int arr[]){
        int n = arr.length;

        ArrayList<HashMap<Long,Long>> dp = new ArrayList<>();
        long ans = 0;

        for(int i=0; i<n; i++){
            HashMap<Long,Long> hpi = new HashMap<>();
            dp.add(hpi);
            for(int j=0; j<i; j++){
                long diff = ((long)arr[i]-(long)arr[j]);
                HashMap<Long,Long> hpj = dp.get(j);
                if(hpj.containsKey(diff)){
                    ans = ans+hpj.get(diff);
                }
                hpi.put(diff,hpi.getOrDefault(diff,(long)0)+hpj.getOrDefault(diff,(long)0)+1);
            }
        }
        return (int)ans;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        return helper(nums);
    }

    public static void main(String[] args) {

        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        JobScheduling jobScheduling = new JobScheduling();
        int res = jobScheduling.jobScheduling(startTime, endTime, profit);
    }
}

