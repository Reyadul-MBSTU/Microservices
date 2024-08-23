

public class ConvertArrayElements {

    public static void main(String[] args) {
        String input = "A,B,C";
        String[] eventType = input.split(",");

        StringBuilder eventTypes = new StringBuilder();
        for (int i = 0; i < eventType.length; i++) {
            eventTypes.append(eventType[i]);
            if (i != eventType.length - 1) {
                eventTypes.append(" , ");
            }
        }
        System.out.println(eventTypes);
    }
}

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

class Tree {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();

        findNode(root, startValue, s);
        findNode(root, destValue, d);

        s.reverse();
        d.reverse();

        int i = 0;
        int temp = Math.min(s.length(), d.length());

        while (i < temp) {
            if (s.charAt(i) == d.charAt(i)) {
                i++;
            } else break;
        }

        int j = i;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            sb.append("U");
            i++;
        }

        sb.append(d.substring(j));

        return sb.toString();
    }

    public boolean findNode(TreeNode root, int value, StringBuilder sb) {
        if (root.val == value) {
            return true;
        }

        if (root.left != null && findNode(root.left, value, sb)) {
            sb.append("L");
        } else if (root.right != null && findNode(root.right, value, sb)) {
            sb.append("R");
        }

        return sb.length() > 0;
    }
}
