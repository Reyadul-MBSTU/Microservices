package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximizeArea {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = find(hBars), y = find(vBars);
        int res = Math.min(x, y) + 1;

        return res * res;
    }

    private int find(int[] arr) {
        Arrays.sort(arr);
        int res = 1, i = 0, n = arr.length;

        while (i < n) {
            int count = 1;

            while (i + 1 < n && arr[i] + 1 == arr[i + 1]) {
                i++;
                count++;
            }
            i++;
            res = Math.max(res, count);
        }

        return res;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int len = r[i] - l[i] + 1;
            if (len > 1) {
                int[] temp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
                // for(int x:temp){
                //     System.out.print(x+" ");
                // }System.out.println();
                Arrays.sort(temp);
                int req = temp[1] - temp[0];
                boolean olredi = false;
                for (int j = 0; j < len - 1; j++) {
                    if (temp[j + 1] - temp[j] != req) {
                        ans.add(false);
                        olredi = true;
                        break;
                    }
                }
                if (!olredi) {
                    ans.add(true);
                }
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public String tictactoe(int[][] moves) {

        LinkedList<String> list1 = new LinkedList<>();
        int start = (moves.length % 2 == 0) ? 1 : 0;
        for (int i = start; i < moves.length; i += 2) {
            list1.add(moves[i][0] + "" + moves[i][1]);
        }

        if (
                (list1.contains("00") && list1.contains("11") && list1.contains("22"))
                        || (list1.contains("02") && list1.contains("11") && list1.contains("20"))
                        || (list1.contains("00") && list1.contains("10") && list1.contains("20"))
                        || (list1.contains("01") && list1.contains("11") && list1.contains("21"))
                        || (list1.contains("02") && list1.contains("12") && list1.contains("22"))
                        || (list1.contains("00") && list1.contains("01") && list1.contains("02"))
                        || (list1.contains("10") && list1.contains("11") && list1.contains("12"))
                        || (list1.contains("20") && list1.contains("21") && list1.contains("22"))
        ) {
            return (moves.length % 2 == 0) ? "B" : "A";
        }

        return (moves.length == 9) ? "Draw" : "Pending";
    }

    public int minimumOneBitOperations(int n) {
        int multiplier = 1;
        int res = 0;
        while (n > 0) {
            res += n ^ (n - 1) * multiplier;
            multiplier = -1 * multiplier;
            n &= n - 1;
        }
        return Math.abs(res);
    }

    public int countCharacters(String[] words, String chars) {
        int count[] = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            int x = chars.charAt(i) - 'a';
            count[x]++;
        }
        int sum = 0;
        for (String s : words) {
            if (check(s, count)) {
                sum += s.length();
            }
        }
        return sum;

    }

    public static boolean check(String s, int[] count) {
        int[] words_arr_length = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int y = s.charAt(i) - 'a';
            words_arr_length[y]++;
            if (words_arr_length[y] > count[y]) return false;
        }
        return true;
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        var time = 0;

        for (var i=1; i < points.length; i++) {
            time +=
                    Math.max(
                            Math.abs(points[i][0] - points[i-1][0]),
                            Math.abs(points[i][1] - points[i-1][1]));
        }
        return time;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};

        MaximizeArea maximizeArea = new MaximizeArea();
        List<Boolean> booleanList = maximizeArea.checkArithmeticSubarrays(nums, l, r);
        int[][] arr = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        String ans = maximizeArea.tictactoe(arr);

        int minimumOneBitOperations = maximizeArea.minimumOneBitOperations(6);
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int count = maximizeArea.countCharacters(words, chars);

        int[][] array = {{1,1},{3,4},{-1,0}};
        int res = maximizeArea.minTimeToVisitAllPoints(array);

        System.out.println(res);

    }
}
