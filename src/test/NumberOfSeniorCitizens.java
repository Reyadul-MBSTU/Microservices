package test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {

        int count = 0;
        for (String detail : details) {
            StringBuilder age = new StringBuilder();
            for (int i = 0; i < detail.length(); i++) {
                if (i == 11) {
                    age.append(detail.charAt(i));
                }
                if (i == 12) {
                    age.append(detail.charAt(i));
                }
            }

            int ages = Integer.parseInt(age.toString());
            if (ages > 60) {
                count++;
            }
        }
        return count;
    }

    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }
        Arrays.sort(arr);
        int minkey = 0;
        int count = 0;
        for (int i = 25; i >= 0; i--) {
            int val = arr[i] * ((count / 8) + 1);
            minkey += val;
            count++;
        }
        return minkey;
    }

    private final String[] belowTwenty = {"", "One", "Two", "Three",
            "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty",
            "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 20) {
            result.append(belowTwenty[num]);
        } else if (num < 100) {
            result.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }
        return result.toString().trim();
    }

    static class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
            } else if (val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }


    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    public static void main(String[] args) {
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        NumberOfSeniorCitizens numberOfSeniorCitizens = new NumberOfSeniorCitizens();
        int count = numberOfSeniorCitizens.countSeniors(details);
        String word = "abcde";
        int ans = numberOfSeniorCitizens.minimumPushes(word);
        System.out.println(ans);
        int num = 123;
        String result = numberOfSeniorCitizens.helper(num);
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8

    }
}
