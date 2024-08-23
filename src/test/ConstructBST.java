package test;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBST {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        TreeNode head = null;

        for (int i = 0; i < descriptions.length; i++) {
            set.add(descriptions[i][1]);
        }

        for (int i = 0; i < descriptions.length; i++) {
            if (!set.contains(descriptions[i][0])) {

                head = map.containsKey(descriptions[i][0])
                        ? map.get(descriptions[i][0])
                        : (new TreeNode(descriptions[i][0]));

                map.put(descriptions[i][0], head);
            }
            TreeNode cur = map.containsKey(descriptions[i][0])
                    ? map.get(descriptions[i][0])
                    : (new TreeNode(descriptions[i][0]));

            map.put(descriptions[i][0], cur);

            if (descriptions[i][2] == 1) {

                cur.left = map.containsKey(descriptions[i][1])
                        ? map.get(descriptions[i][1]) :
                        (new TreeNode(descriptions[i][1]));

                map.put(descriptions[i][1], cur.left);
            }
            else {

                cur.right = map.containsKey(descriptions[i][1])
                        ? map.get(descriptions[i][1]) :
                        (new TreeNode(descriptions[i][1]));

                map.put(descriptions[i][1], cur.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        ConstructBST constructBST = new ConstructBST();
        TreeNode head = constructBST.createBinaryTree(descriptions);

    }
}
