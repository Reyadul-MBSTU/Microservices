package test;

import java.util.HashMap;
import java.util.Map;

public class MaximumPair {

    public int maximumNumberOfStringPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String s = String.valueOf(sort(words[i]));
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int max = 0;
        for (Integer count : map.values()) {
            if (count > max && count > 1) {
                max = count;
            }
        }
        return max;
    }

    char[] sort(String word) {
        char[] ch = word.toCharArray();
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = 0; j < word.length() - 1 - i; j++) {
                if (ch[j] > ch[j + 1]) {
                    char c = ch[j];
                    ch[j] = ch[j + 1];
                    ch[j + 1] = c;
                }
            }
        }
        return ch;
    }

    public int longestString(int x, int y, int z) {
        int longestString = 0;

        //Account for 'AB' repetitions
        //AB is versatile because they can be used back to back or they can be used prepended by BB or appended by AA
        //Because AA, BB are best used together, then we should just stick to alternating AB-AB together
        longestString += z * 2;

        //Start alternating AABB pairs
        //AA and BB are best used when used together first since they are worth 4 together
        int aabbCount = Math.min(x, y);

        longestString += aabbCount * 4;
        x -= aabbCount;
        y -= aabbCount;

        //Account for leftover AA,BB

        //Lastly, append an AA if possible
        if (x > 0) {
            longestString += 2;
        }

        //Lastly, prepend BB if possible
        if (y > 0) {
            longestString += 2;
        }

        //End product looks like {Singular BB prepend if available} + {ABAB... pairs} + {AABB... pairs}  + {Singular AA append if available}
        //ex: BB-ABABABABABAB-AABBAABB-AA

        return longestString;

    }

    public int longestSubarray(int[] nums) {
        int zeroIndex = -1, max = 0, n = nums.length;

        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] == 0) {
                l = zeroIndex + 1;
                zeroIndex = r;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxFreq = 0;
        int i = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int j = 0; j < answerKey.length(); j++) {
            char currentChar = answerKey.charAt(j);
            charCount.put(currentChar,
                    charCount.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, charCount.get(currentChar));

            if (j - i + 1 > maxFreq + k) {
                charCount.put(answerKey.charAt(i),
                        charCount.get(answerKey.charAt(i)) - 1);
                i++;
            }
        }

        return answerKey.length() - i;
    }

    public static void main(String[] args) {
        String[] words = {"cd", "ac", "dc", "ca", "zz"};
        MaximumPair maximumPair = new MaximumPair();
        int res = maximumPair.maximumNumberOfStringPairs(words);

        int x = 2, y = 5, z = 1;
        int ans = maximumPair.longestString(x, y, z);
        System.out.println(ans);

        int[] arr = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int result = maximumPair.longestSubarray(arr);

        String answerKey = "TTFTTFTT";
        int k = 1;
        int r = maximumPair.maxConsecutiveAnswers(answerKey, k);
        System.out.println(r);
    }
}

