package ApnaCollege;

public class PathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) return true;
        UnionFind uf = new UnionFind(n);
        for (var edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.connected(source, destination);
    }

    public class UnionFind {
        private int root [];
        private int rank [];

        public UnionFind(int size) {
            root = new int [size];
            rank = new int [size];

            for (int i =0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        int n = 3, source = 0, destination = 2;
        int[][] edges = {{0,1},{1,2},{2,0}};
        PathExists pathExists = new PathExists();
        boolean ans = pathExists.validPath(n, edges, source, destination);
        System.out.println(ans);
    }
}
