package test;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSubSequence {

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : arr) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num + difference, freq);
            max = Math.max(max, freq);
        }

        return max;
    }


        public boolean digitCount(String num) {
            Map<Integer, Integer> map = new HashMap<>();
            for (char c : num.toCharArray()) {
                int n = c - '0';
                map.put(n, 1 + map.getOrDefault(n, 0));
            }

            for (int i = 0; i < num.length(); i++) {
                int n = num.charAt(i) - '0';
                if (n != map.getOrDefault(i, 0)) {
                    return false;
                }
            }

            return true;
        }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4}; int difference = 1;
        ArithmeticSubSequence arithmeticSubSequence = new ArithmeticSubSequence();
        int res = arithmeticSubSequence.longestSubsequence(arr, 1);

        String num = "030";
        boolean ans = arithmeticSubSequence.digitCount(num);
    }
}
