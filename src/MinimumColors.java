public class MinimumColors {

    public static int minimumRecolors(String blocks, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        while (j < blocks.length()) {
            if (blocks.charAt(j) == 'W')
                ans++;
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                min = Math.min(ans, min);
                if (blocks.charAt(i) == 'W')
                    ans--;
                j++;
                i++;
            }
        }
        return min;
    }

    public int secondsToRemoveOccurrences(String s) {
            int res = 0;

            int zeroCount = 0;

            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '0') zeroCount++;
                if (s.charAt(i) == '1' && zeroCount>0)
                    res = Math.max(res+1, zeroCount);
            }

            return res;
        }

    public static void main(String[] args) {

    }
}
