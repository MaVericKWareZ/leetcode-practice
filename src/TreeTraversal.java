import java.util.*;

public class TreeTraversal {

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static List<List<Integer>> levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();
        if (node == null) return wrapList;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int index = 0; index < size; index++) {
                if (queue.peek() != null && queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek() != null && queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                TreeNode curr = queue.poll();
                subList.add(curr.data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
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

        System.out.println("InOrder Traversal");
        inOrder(root);
        System.out.println();
        System.out.println("PreOrder Traversal");
        preOrder(root);
        System.out.println();
        System.out.println("PostOrder Traversal");
        postOrder(root);
        System.out.println();
        System.out.println("LevelOrder Traversal");
        List<List<Integer>> traversal = levelOrder(root);
        System.out.println(traversal);
        System.out.println("IterativePreOrder Traversal");
        List<Integer> preOrder = iterativePreOrder(root);
        System.out.println(preOrder);
        System.out.println("IterativeInOrder Traversal");
        List<Integer> inOrder = iterativeInOrder(root);
        System.out.println(inOrder);
        System.out.println("IterativePostOrder Traversal");
        List<Integer> postOrder = iterativePostOrder(root);
        System.out.println(postOrder);

    }

    public static List<Integer> iterativePreOrder(TreeNode node) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            traversal.add(curr.data);
            if (curr.right != null) stack.add(curr.right);
            if (curr.left != null) stack.add(curr.left);
        }
        return traversal;
    }

    public static List<Integer> iterativeInOrder(TreeNode node) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = node;
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                TreeNode currNode = stack.pop();
                traversal.add(currNode.data);
                root = currNode.right;
            }
        }
        return traversal;
    }

    public static List<Integer> iterativePostOrder(TreeNode node) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }
        while (!stack2.isEmpty()) {
            traversal.add(stack2.pop().data);
        }
        return traversal;
    }
}
