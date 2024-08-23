public class KadanesAlgorithm {

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n) {
        long max = -((int) 1e7);
        long crr = max;
        for (int x = 0; x < n; x++) {
            crr = Math.max(arr[x] + crr, arr[x]);
            if (crr > max) max = crr;
        }
        return max;
    }

    static int mod = (int) 1e9 + 7;

    static int nCr(int n, int r) {
        // code here
        if (r > n)
            return 0;
        int[] prev = new int[r + 1];
        int[] curr = new int[r + 1];
        prev[0] = curr[0] = 1;
        if (r == n || r == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                curr[j] = (prev[j - 1] + prev[j]) % mod;
            }
            prev = curr.clone();
        }
        return prev[r];
    }

    public static void main(String[] args) {
        int Arr[] = {1, 2, 3, -2, 5};
        int n = 5;
        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        long ans = kadanesAlgorithm.maxSubarraySum(Arr, n);
    }
}
