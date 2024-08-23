package problemSolving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSquare {

    private static final int modulo = (int) 1e9 + 7;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> seen = new HashSet<>();
        int l = hFences.length + 2;
        int[] h = Arrays.copyOf(hFences, l);
        // add both boundary
        h[l - 2] = 1;
        h[l - 1] = m;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                seen.add(Math.abs(h[j] - h[i]));
            }
        }

        l = vFences.length + 2;
        int[] v = Arrays.copyOf(vFences, l);
        // add both boundary
        v[l - 2] = 1;
        v[l - 1] = n;

        int side = 0;
        // check vertical fences
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int distance = Math.abs(v[j] - v[i]);
                if (seen.contains(distance)) {
                    side = Math.max(side, distance);
                }
            }
        }

        if (side == 0) {
            return -1;
        }

        return (int) ((long) side * side % modulo);
    }
}
