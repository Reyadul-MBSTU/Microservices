package test;

public class LongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            int i = freq[s.charAt(right) - 'A'];
            i++;
            mostFreqLetter = Math.max(mostFreqLetter, i);

            int lettersToChange = (right - left + 1) - mostFreqLetter;
            if (lettersToChange > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacter longestRepeatingCharacter = new LongestRepeatingCharacter();
        int ans = longestRepeatingCharacter.characterReplacement("ABAB", 2);
        System.out.println(ans);
    }
}
