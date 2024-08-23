package problemSolving;

public class CircularString {

    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        for (char c : str2.toCharArray()) {
            char t = (c == 'a') ? 'z' : (char) (c - 1);
            while (i < str1.length() &&
                    (str1.charAt(i) != c && str1.charAt(i) != t)) i++;
            if (i >= str1.length()) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abc", str2 = "ad";
        CircularString circularString = new CircularString();
        boolean res = circularString.canMakeSubsequence(str1, str2);
        System.out.println(res);
    }
}
