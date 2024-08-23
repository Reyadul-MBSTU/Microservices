package problemSolving;

public class PalindromicSubString {

    int left;
    int right;

    public int countSubstrings(String s) {
        int result = 1;

        for (int i = 1; i < s.length(); i++) {
            left = i - 1;
            right = i;
            helper(s);
            result += (right - left) / 2;

            left = i;
            right = i;
            helper(s);
            result += (right - left) / 2;
        }

        return result;
    }

    private void helper(String s) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right))
                break;

            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s ="abc";
        PalindromicSubString palindromicSubString = new PalindromicSubString();
        int ans = palindromicSubString.countSubstrings(s);
    }
}
