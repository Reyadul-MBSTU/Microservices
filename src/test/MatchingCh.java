package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class MatchingCh {

        public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
            Arrays.sort(hBars);
            Arrays.sort(vBars);

            int maxHGap = getMaxGap(hBars, n);
            int maxVGap = getMaxGap(vBars, m);

            return maxHGap * maxVGap;
        }

        private int getMaxGap(int[] bars, int size) {
            int maxGap = 0;
            int prev = 0;

            for (int bar : bars) {
                maxGap = Math.max(maxGap, bar - prev - 1);
                prev = bar;
            }

            // Check the gap between the last bar and the end
            maxGap = Math.max(maxGap, size - prev);

            return maxGap;
        }

        public static void main(String[] args) {
            MatchingCh solution = new MatchingCh();

            // Example 1
            int n1 = 2, m1 = 1;
            int[] hBars1 = {2, 3};
            int[] vBars1 = {2};
            System.out.println(solution.maximizeSquareHoleArea(n1, m1, hBars1, vBars1)); // Output: 4

            // Example 2
            int n2 = 1, m2 = 1;
            int[] hBars2 = {2};
            int[] vBars2 = {2};
            System.out.println(solution.maximizeSquareHoleArea(n2, m2, hBars2, vBars2)); // Output: 4

            // Example 3
            int n3 = 2, m3 = 3;
            int[] hBars3 = {2, 3};
            int[] vBars3 = {2, 3, 4};
            System.out.println(solution.maximizeSquareHoleArea(n3, m3, hBars3, vBars3)); // Output: 9
        }
    }



