package problemSolving;

public class RepeatedString {
        public boolean repeatedSubstringPattern(String s) {
            // String str = s + s;
            // return str.substring(1, str.length() - 1).contains(s);
            int len = s.length(), mid = 0;
            if(len%2!=0)
            {
                mid = (s.length()/2)+1;
            }
            else
            {
                mid = s.length()/2;
            }
            String s1 = "";
            for(int i=0; i<mid; i++)
            {
                s1+=s.charAt(i);
            }
            String s2 = "";
            for(int i=mid; i<s.length(); i++)
            {
                s2+=s.charAt(i);
            }
            if(s1.length()!=s2.length())
            {
                return false;
            }
            for(int i=0; i<s1.length(); i++)
            {
                if(s1.charAt(i)!= s2.charAt(i))
                {
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        String s = "abab";
        RepeatedString repeatedString = new RepeatedString();
        boolean res = repeatedString.repeatedSubstringPattern(s);
        System.out.println(res);
    }
}
