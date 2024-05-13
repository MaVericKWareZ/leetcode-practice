class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

class BinaryTreeModel {
    TreeNode root;
    int diameter;

    public BinaryTreeModel(int data) {
        this.root = new TreeNode(data);
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int balanced(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = balanced(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = balanced(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(rightHeight, leftHeight) + 1;
    }

    public int diameter(TreeNode node) {
        int[] diameter = new int[1];
        recursiveDiameterCheck(node, diameter);
        return diameter[0];
    }

    public int recursiveDiameterCheck(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = recursiveDiameterCheck(node.left, diameter);
        int rightHeight = recursiveDiameterCheck(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTreeModel tree = new BinaryTreeModel(1);
        TreeNode root = tree.root;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        int height = tree.maxDepth(root);
        System.out.println("height = " + height);
        int balanced = tree.balanced(root);
        System.out.println("balanced = " + balanced);
        int diameter = tree.diameter(root);
        System.out.println("diameter = " + diameter);
    }
}
