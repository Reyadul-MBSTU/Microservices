import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestSubstring {

        public int maxLengthBetweenEqualCharacters(String s) {

            if(s.length()==0 || s.length()==1) return -1;

            if(s.length()==2) return 0;

            List<Integer> list = new ArrayList<>();
            List<Character> ch = new ArrayList<>();

            int k = 0;
            for(int i=0; i<s.length(); i++)
            {
                ch.add(s.charAt(i));
            }
            int count;
            for(int i=1; i<ch.size(); i++)
            {
                count = 0;
                char c = ch.get(k);
                for(int j = i+1; j<ch.size(); j++)
                {
                    if(ch.get(j)==c)
                    {
                        list.add(count);
                    }
                    count++;
                }
                k++;

            }
            Collections.sort(list);
            return list.size()==0?-1:list.get(list.size()-1);
        }

    public static void main(String[] args) {
        String ans = "scayofdzca";
        LargestSubstring largestSubstring = new LargestSubstring();
        int res = largestSubstring.maxLengthBetweenEqualCharacters(ans);
    }
}
