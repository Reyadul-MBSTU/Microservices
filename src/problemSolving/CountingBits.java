package problemSolving;

public class CountingBits {

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        int next = 1, j = 0;
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i == next) { // next Binary Cycle
                next *= 2;
                j = 0; // index used to Reuse arr
            }
            arr[i] = 1 + arr[j++];
        }
        return arr;
    }


    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            for (String word : dictionary) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - len]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] res = countingBits.countBits(2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        String s = "leetscode";
        String[] dictionary = {"leet","code","leetcode"};
        int result = countingBits.minExtraChar(s, dictionary);
        System.out.println(result);
        int a = 5;
        int b = a++ + ++a;

        System.out.println(b);
    }
}
