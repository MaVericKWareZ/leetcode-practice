import java.util.ArrayList;
import java.util.List;

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

    public int getDiameter(TreeNode node) {
        int[] diameter = new int[1];
        recursiveDiameterCheck(node, diameter);
        return diameter[0];
    }

    private int recursiveDiameterCheck(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = recursiveDiameterCheck(node.left, diameter);
        int rightHeight = recursiveDiameterCheck(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }


    private int maxPath(TreeNode node, int[] maxPathSum) {
        if (node == null) {
            return 0;
        }

        int leftPath = Math.max(0, maxPath(node.left, maxPathSum));
        int rightPath = Math.max(0, maxPath(node.right, maxPathSum));
        maxPathSum[0] = Math.max(maxPathSum[0], node.data + leftPath + rightPath);
        return node.data + Math.max(leftPath, rightPath);
    }

    public int getMaxPathSum(TreeNode node) {
        int[] maxPathSum = new int[1];
        maxPathSum[0] = Integer.MIN_VALUE;
        maxPath(node, maxPathSum);
        return maxPathSum[0];
    }

    public boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        return (node1.data == node2.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node1.right);
    }

    public List<Integer> pathToNode(TreeNode node, int target) {
        List<Integer> path = new ArrayList<>();
        if (node == null) {
            return path;
        }
        getPath(node, target, path);
        return path;
    }

    public boolean getPath(TreeNode node, int target, List<Integer> path) {
        if (node == null) {
            return false;
        }

        path.add(node.data);
        if (node.data == target) {
            return true;
        }


        boolean left = getPath(node.left, target, path);
        boolean right = getPath(node.right, target, path);
        if (left || right) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }


        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        if (left != null) root.right = left;
        if (right != null) root.left = right;

        return root;

    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        boolean isLeaf = isLeafNode(root);

        if (isLeaf && targetSum == root.data) {
            return true;
        }

        int updatedSum = targetSum - root.data;

        boolean isPresentInLeftSubTree = hasPathSum(root.left, updatedSum);

        boolean isPresentInRightSubTree = hasPathSum(root.right, updatedSum);


        return isPresentInLeftSubTree || isPresentInRightSubTree;


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
        int diameter = tree.getDiameter(root);
        System.out.println("diameter = " + diameter);
        int maxPathSum = tree.getMaxPathSum(root);
        System.out.println("maxPathSum = " + maxPathSum);

        TreeNode root1 = new TreeNode(-3);
        int max = tree.getMaxPathSum(root1);
        System.out.println("max = " + max);


    }
}
