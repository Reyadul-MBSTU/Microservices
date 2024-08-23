package test;

public class UniqueCount {

    public static void main(String[] args) {
        countOfCharacter("abc", 10);
    }
    private static void countOfCharacter(String s, int n)
    {
        if(s.length()>n)
        {
            return;
        }
        StringBuilder str = new StringBuilder();
        //int j=0;

        for(int i=0; i<n-s.length(); i++)
        {
            str.append(s.charAt(i%s.length()));
        }
        System.out.println(s+str.toString());
    }
}
