package test;

import java.util.HashMap;
import java.util.Map;

public class Task {
    public static void main(String args[]) {
        String input = "sss";
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int[] ch = new int[26];

        for (int i = 0; i < input.length(); i++) {
            ch[input.charAt(i)]++;
            char z = input.charAt(i);
            if (input.charAt(i) == z) {
                i++;
            }
            i--;
           // if (ch(z) > 1) ans = 1;

        }
        if (ans == 1) {
            System.out.println("N0");
        } else {
            System.out.println("YES");
        }
    }
}
