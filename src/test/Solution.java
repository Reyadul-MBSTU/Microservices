package test;

class Solution {
    public static int longestSemiRepetitiveSubstring(String s) {
        int i = 1;
        int res = 0;
        int flag = 0;    //to check whether a pair exists
        int index = -1;   //location of pair
        int j = 0;        //start index
        while (i < s.length()) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (flag == 0) {
                    index = i;
                    flag = 1;
                    res = Math.max(res, i - j + 1);
                    i++;
                } else {
                    j = index;
                    flag = 0;
                }
            } else {
                if (flag == 1) {
                    res = Math.max(res, i - j + 1);
                }
                i++;
            }
        }
        if (res == 0) {
            return s.length();
        }

        return res;
    }


    public static void main(String[] args) {
        String s1 = "52233";
        System.out.println(longestSemiRepetitiveSubstring(s1));  // Output: 4

        String s2 = "5494";
        System.out.println(longestSemiRepetitiveSubstring(s2));  // Output: 4

        String s3 = "001";
        System.out.println(longestSemiRepetitiveSubstring(s3));  // Output: 2
    }
}
