package problemSolving;

public class Solution {
    private int bs(int a[], int k, int l,int r){
        int lo=l,hi=r,mid;
        while(lo<=hi){
            mid=lo+(hi-lo)/2;
            if(a[mid]==k)return mid;
            if(a[mid]>k){
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return -1;
    }

    private int findRotIdx(int nums[]){
        int lo=0,hi=nums.length-1,mid,res=0;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(nums[lo]>nums[hi]){
                if(nums[mid]<nums[lo]){
                    res=mid;
                    hi=mid;
                }
                else {
                    res=mid;
                    lo=mid+1;
                }
            }
            else {
                hi=mid-1;
                res=mid;
            }
        }
        return res;
    }

    public int search(int[] nums, int target) {
        int r=findRotIdx(nums);
        System.out.println(r);
        int x=bs(nums,target,0,r-1);
        if(x!=-1)return x;
        return bs(nums,target,r,nums.length-1);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int c : coins) {
            for (int a = c; a <= amount; a++) {
                dp[a] += dp[a - c];
            }
        }

        return dp[amount];
    }
        Boolean dp[];
        public boolean solve(int arr[],int i){
            if(i>=arr.length)   return true;
            // if(i>arr.length)    return false;
            if(dp[i]!=null) return dp[i];
            if(i<=(arr.length-3) && arr[i]==arr[i+1] && arr[i+1]==arr[i+2]){
                return dp[i]= solve(arr,i+2) || solve(arr,i+3);
            }
            if(i<=(arr.length-2) && arr[i]==arr[i+1]){
                return  dp[i]=solve(arr,i+2);
            }
            if(i<=(arr.length-3)){
                if((arr[i+1]-arr[i])==1 && (arr[i+2]-arr[i+1])==1){
                    return dp[i]=solve(arr,i+3);
                }
            }
            System.out.println(i);
            return false;
        }
        public boolean validPartition(int[] nums) {
            dp = new Boolean[nums.length];
            return solve(nums,0);
        }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        Solution solution = new Solution();
        int res = solution.search(nums, target);
        int[] num = {1,2,5};
        int result = solution.change(5, num);
        int[] arr = {4,4,4,5,6};
        boolean r = solution.validPartition(arr);
    }
}
