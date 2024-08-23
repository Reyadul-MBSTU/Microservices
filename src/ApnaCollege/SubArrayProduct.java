package ApnaCollege;

public class SubArrayProduct {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0, prod = 1, start = 0;
        for (int i = 0; i < n; i++) {
            prod *= nums[i];
            while (prod >= k && start < i) {
                prod /= nums[start];
                start++;
            }
            if (prod < k)
                count += (i - start + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        SubArrayProduct subArrayProduct = new SubArrayProduct();
        int res = subArrayProduct.numSubarrayProductLessThanK(nums, k);
    }
}
