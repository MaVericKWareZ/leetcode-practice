import java.util.Stack;

public class BinarySearchTree {

    public static int counter = 0;
    public static int ans = 0;

    public static TreeNode searchNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        if (target > root.data) {
            return searchNode(root.right, target);
        }
        return searchNode(root.left, target);
    }

    public static int findKthSmallestElement(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        int counter = 0;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            counter++;
            if (counter == k) {
                return current.data;
            }
            current = current.right;
        }
        return -1;
    }

    public static int recursiveKthSmallest(TreeNode root, int k) {
        solve(root, k);
        return ans;
    }

    public static void solve(TreeNode node, int k) {
        if (node == null) return;

        solve(node.left, k);
        counter++;
        if (counter == k) {
            ans = node.data;
            return;
        }
        solve(node.right, k);
    }

    public static boolean validateBST(TreeNode node) {
        return validateNode(node, null, null);
    }

    public static boolean validateNode(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if ((low == null || node.data > low) && (high == null || high < node.data)) return false;
        return validateNode(node.left, low, node.data) && validateNode(node.right, node.data, high);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(8);
        TreeNode root = tree.root;
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        int target = 13;
        TreeNode searchRes = searchNode(root, target);
        System.out.println("searchRes = " + searchRes.data);

        int thirdSmallest = findKthSmallestElement(root, 3);
        System.out.println("thirdSmallest = " + thirdSmallest);

        int recursiveThirdSmallest = recursiveKthSmallest(root, 3);
        System.out.println("recursiveThirdSmallest = " + recursiveThirdSmallest);

        BinaryTree tree2 = new BinaryTree(Integer.MIN_VALUE);
        TreeNode root2 = tree2.root;
        boolean validate = validateBST(root2);
        System.out.println("validate = " + validate);
    }
}
