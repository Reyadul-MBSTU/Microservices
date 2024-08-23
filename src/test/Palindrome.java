package test;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null)
            return true;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                str.append(s.charAt(i));
            }
        }
        String string = str.toString();
        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            String ck1 = String.valueOf(string.charAt(i));
            String ck2 = String.valueOf(string.charAt(j));
            if (!ck1.equalsIgnoreCase(ck2)) {
                return false;
            }
        }
        return true;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int start = 0,  end = 0,  sum = 0,  minLength = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end++];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start);
                sum -= nums[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean isResult = Palindrome.isPalindrome(s);
        System.out.println(isResult);

        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        int result = Palindrome.minSubArrayLen(target, nums);
        System.out.println(result);
    }
}
