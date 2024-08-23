package test;

public class Province {
    private void findCircleNumHelp(int node, int vis[], int adj[][]) {
        vis[node] = 1;
        for (int i = 0; i < adj[node].length; i++) {
            if (i != node && adj[node][i] == 1 &&
                    vis[i] == 0)
                findCircleNumHelp(i, vis, adj);
        }
    }


    public int findCircleNum(int[][] ic) {
        int n = ic.length, cnt = 0, vis[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                findCircleNumHelp(i, vis, ic);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        Province province = new Province();
        int res = province.findCircleNum(isConnected);
    }
}
