package problemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConnectedPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{distance, i, j});
            }
        }

        Collections.sort(edges, Comparator.comparingInt(a -> a[0]));

        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        int minCost = 0;
        int numEdges = 0;

        for (int[] edge : edges) {
            int distance = edge[0];
            int u = edge[1];
            int v = edge[2];

            int parentU = findParent(parent, u);
            int parentV = findParent(parent, v);

            if (parentU != parentV) {
                parent[parentU] = parentV;
                minCost += distance;
                numEdges++;

                if (numEdges == n - 1) {
                    break;
                }
            }
        }

        return minCost;
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findParent(parent, parent[node]);
        return parent[node];
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        ConnectedPoints connectedPoints = new ConnectedPoints();
        int res = connectedPoints.minCostConnectPoints(points);
    }
}
