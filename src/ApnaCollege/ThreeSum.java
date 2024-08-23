package ApnaCollege;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        bubbleSort(nums);
        int i=0, j, k;
        while(i< nums.length-2)
        {
            j=i+1;
            k=nums.length-1;

            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]== 10)
                {
                    set.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<10)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
            i++;
        }
        return new ArrayList<List<Integer>>(set);
    }

    private void bubbleSort(int[] nums)
    {
        for(int i=0; i<nums.length-1; i++)
        {
            for(int j=0; j<nums.length-1-i; j++)
            {
                if(nums[j]>nums[j+1])
                {
                    int temp = nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4, 6, 7, 8, 5};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> list = threeSum.threeSum(nums);
        System.out.println(list);

    }
}

