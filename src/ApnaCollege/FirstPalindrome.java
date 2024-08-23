package ApnaCollege;

import java.util.*;

public class FirstPalindrome {

    public String firstPalindrome(String[] words) {
        if (words.length == 0) {
            return "";
        }
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == str.charAt(end)) {
            start++;
            end--;
        }

        if (end < start)
            return true;

        return false;
    }

    public static void maxPalindrome(int p) {
        int max = Integer.MIN_VALUE;
        for (int i = 101; i < 1000; i++) {

            for (int j = 121; j < 1000; j += (i % 11 == 0) ? 1 : 11) {

                int num = i * j;
                boolean val = isPalindrome(num);

                if (val)
                    if (num < p)
                        max = Math.max(max, num);
            }
        }

        System.out.println(max);
    }

    public String getKeyValue() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        List<Integer> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Integer, String> m : map.entrySet()) {
            list.add(m.getKey());
            // System.out.println(m.getKey()+" "+m.getValue());
        }
        Collections.sort(list);
        for (Map.Entry<Integer, String> m : map.entrySet()) {
            //list.add(m.getKey());
            stringBuilder.append(m.getKey() + " " + m.getValue() + "\n");
        }
        return stringBuilder.toString();
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        long[] times = new long[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            boolean flag = false;
            int minind = -1;
            long val = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (times[j] < val) {
                    val = times[j];
                    minind = j;
                }
                if (times[j] <= start) {
                    flag = true;
                    ans[j]++;
                    times[j] = end;
                    break;
                }
            }
            if (!flag) {
                ans[minind]++;
                times[minind] += (end - start);
            }
        }

        int maxi = -1, id = -1;
        for (int i = 0; i < n; i++) {
            if (ans[i] > maxi) {
                maxi = ans[i];
                id = i;
            }
        }
        return id;
    }



    public static void main(String[] args) {
        FirstPalindrome firstPalindrome = new FirstPalindrome();
        //  System.out.println(firstPalindrome.autoIncrement());
        ///  System.out.println(firstPalindrome.autoIncrement());
        //  System.out.println(firstPalindrome.autoIncrement());
        Scanner in = new Scanner(System.in);
        // int t = in.nextInt();
        //  for (int a0 = 0; a0 < t; a0++) {
        //   int n = in.nextInt();
        //  maxPalindrome(n);
        // }
        String res = firstPalindrome.getKeyValue();
        System.out.println(res);
        int n = 2;
        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        int result = firstPalindrome.mostBooked(n, meetings);
        String s = null;
        System.out.println(s.toLowerCase());
    }

}
