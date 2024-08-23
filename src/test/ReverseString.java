package test;

public class ReverseString {

    public String reverseWords(String s) {
        s = s.trim() + " ";
        String ans = "", word = "";
        int fg = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                fg = 0;
                word += s.charAt(i);
            } else if (fg == 0) {
                fg = 1;
                ans = word + " " + ans;
                word = "";
            }
        }
        return ans.trim();
    }
   int a;
    public static  String call()
    {
        return null;
    }

    public final void call(int x)
    {

    }

    private void call(Long x)
    {

    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String s = "the sky is blue";
        String res = reverseString.reverseWords(s);

    }
}

class X extends ReverseString
{
    static void sum()
    {

    }
    public static void main(String[] args) {
        ReverseString reverseString = new X();
       // X x = (X) reverseString;
       // X ob = (X) new ReverseString();
      //  reverseString.reverseWords()
        reverseString.call(10);
        reverseString.a =10;
       // reverseString.sum();


    }
}
