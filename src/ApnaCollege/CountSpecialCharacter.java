package ApnaCollege;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialCharacter {

    public int numberOfSpecialChars(String word) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);

        }
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getKey() >= 97) {
                if (map.containsKey((char) (m.getKey() - 32))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String word = "aaAbcBC";
        CountSpecialCharacter countSpecialCharacter = new CountSpecialCharacter();
        int res = countSpecialCharacter.numberOfSpecialChars(word);
    }
}
