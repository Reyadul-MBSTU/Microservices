package ApnaCollege;

public class SmallestMissing {
    //Function to find the smallest positive number missing from the array.
    public static int missingNumber(int[] arr, int n) {
        // Separate positive and non-positive numbers by rearranging the array
        int positiveCount = segregate(arr, n);

        // Consider only the positive part of the array for finding the missing number
        int[] positiveArray = new int[n - positiveCount];
        int j = 0;
        for (int i = positiveCount; i < n; i++) {
            positiveArray[j] = arr[i];
            j++;
        }

        // Mark the visited numbers using the index as a marker
        for (int i = 0; i < positiveArray.length; i++) {
            int x = Math.abs(positiveArray[i]);
            if (x > 0 && x <= positiveArray.length) {
                int index = x - 1;
                if (positiveArray[index] > 0) {
                    positiveArray[index] = -positiveArray[index];
                }
            }
        }

        // Find the first positive index (i.e., the missing number)
        for (int i = 0; i < positiveArray.length; i++) {
            if (positiveArray[i] > 0) {
                return i + 1;
            }
        }

        // If all numbers from 1 to n are present, return n + 1
        return positiveArray.length + 1;
    }

    // Rearrange the array to separate positive and non-positive numbers
    private static int segregate(int[] arr, int n) {
        int positiveCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[positiveCount];
                arr[positiveCount] = temp;
                positiveCount++;
            }
        }
        return positiveCount;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -2, 1, -2 ,0, -3, -4, -4, 0};
        int n=9;
        int ans = SmallestMissing.missingNumber(arr, n);
        System.out.println(ans);
    }
}
