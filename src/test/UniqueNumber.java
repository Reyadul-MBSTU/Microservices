package test;

import java.util.Arrays;

public class UniqueNumber {

    public int findDuplicate(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        int[] weakestRows = new int[mat.length];
        int rows = mat.length;
        for (int i = 0; i < rows; i++) {
            weakestRows[i] = (numberOfOnes(mat[i]) * rows) + i;
        }
        Arrays.sort(weakestRows);
        for (int i = 0; i < rows; i++)
            weakestRows[i] %= rows;
        return Arrays.copyOfRange(weakestRows, 0, k);
    }

    static int numberOfOnes(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == 1) {
                answer = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3};
        UniqueNumber uniqueNumber = new UniqueNumber();
        int ans = uniqueNumber.findDuplicate(arr);
        System.out.println(ans);
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1,1,1,1,1}};
        int[] array = uniqueNumber.kWeakestRows(mat, 3);
    }
}
