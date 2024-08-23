package ApnaCollege;

import java.util.*;

public class Solution {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int pivot = randomPartition(arr, l, r);
            if (pivot - l == k - 1) {
                return arr[pivot];
            }
            if (pivot - l > k - 1) {
                return kthSmallest(arr, l, pivot - 1, k);
            }
            return kthSmallest(arr, pivot + 1, r, k - pivot + l - 1);
        }
        return -1;
    }

    private static int randomPartition(int[] arr, int l, int r) {
        int pivotIndex = new Random().nextInt(r - l + 1) + l;
        swap(arr, pivotIndex, r);
        return partition(arr, l, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();

        for (int[] n : matches) {
            hashMap.put(n[0], hashMap.getOrDefault(n[0], 0));
            hashMap.put(n[1], hashMap.getOrDefault(n[1], 0) + 1);
        }

        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();

        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            if (map.getValue() == 0) winner.add(map.getKey());
            else if (map.getValue() == 1) loser.add(map.getKey());
        }

        Collections.sort(winner);
        Collections.sort(loser);
        result.add(winner);
        result.add(loser);

        return result;
    }


    public boolean uniqueOccurrences(int[] arr) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int v : arr) {
//            if (map.containsKey(v)) {
//                map.put(v, map.get(v) + 1);
//            } else {
//                map.put(v, 1);
//            }
//        }
//        List<Integer> list = map.entrySet().stream().map(v -> v.getValue()).collect(Collectors.toList());
//        List<Integer> l = new ArrayList<>();
//
//        for (Integer m : map.values()) {
//            l.add(m);
//        }
//        Collections.sort(l);
//        for (int i = 0; i < l.size() - 1; i++) {
//            if (l.get(i) == l.get(i + 1)) {
//                return false;
//            }
//        }
//
//        return true;
        int[] array = new int[10];
        for (int i : arr) {
            array[i]++;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != 0) {
                if (array[i] == array[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        int sum = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < col; i++) {
            sum = Math.min(sum, rectangle(0, i, A, map));
        }
        return sum;
    }

    private static int rectangle(int i, int j, int[][] A, Map<String, Integer> map) {
        int row = A.length;
        int col = A[0].length;

        if (i == row) return 0;
        if (j < 0 || j >= col) {
            return Integer.MAX_VALUE;
        }

        String key = i + "bit" + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int op1 = rectangle(i + 1, j - 1, A, map);
        int op2 = rectangle(i + 1, j, A, map);
        int op3 = rectangle(i + 1, j + 1, A, map);
        map.put(key, A[i][j] + Math.min(op1, Math.min(op2, op3)));

        return A[i][j] + Math.min(op1, Math.min(op2, op3));

    }


    public int sumSubarrayMins(int[] arr) {
        int[] stk = new int[arr.length + 1];
        int idx = 0;

        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        long res = dp[0];
        for (int i = 1; i < arr.length; i++) {
            while (idx >= 0 && arr[stk[idx]] >= arr[i]) {
                idx--; // popping stack top
            }

            dp[i] = idx < 0 ? arr[i] * (i + 1) : dp[stk[idx]] + (arr[i] * (i - stk[idx]));
            res += dp[i];
            stk[++idx] = i; // pushing into stack
        }

        return (int) (res % 1_000_000_007);
    }


    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        Solution s = new Solution();
        List<List<Integer>> res = s.findWinners(matches);
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean result = s.uniqueOccurrences(arr);
        int[][] array = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int ans = s.minFallingPathSum(array);
        System.out.println(ans);
        int[] subarray = {3,1,2,4};
        int rs = s.sumSubarrayMins(subarray);
        System.out.println(rs);
    }
}

