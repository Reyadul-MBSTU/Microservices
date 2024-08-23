package test;

import java.util.*;

public class BitsWiseSorting {

    public int one(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {

        String s = "";
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            s = Integer.toBinaryString(arr[i]);
            int l = one(s);
            map.put(arr[i], l);
            set.add(l);
        }

        int[] temp = new int[set.size()];

        Iterator<Integer> itr = set.iterator();
        int index = 0;

        while (itr.hasNext()) {
            temp[index++] = itr.next();
        }

        Arrays.sort(temp);

        int[] res = new int[arr.length];
        index = 0;

        for (int i = 0; i < temp.length; i++) {
            int ch = temp[i];
            for (int j = 0; j < arr.length; j++) {
                if (map.get(arr[j]) == ch) {
                    res[index++] = arr[j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[]  arr = {0,1,2,3,4,5,6,7,8};
        BitsWiseSorting bitsWiseSorting = new BitsWiseSorting();
        int[] ans = bitsWiseSorting.sortByBits(arr);
    }
}

