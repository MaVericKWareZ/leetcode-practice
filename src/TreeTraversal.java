import java.util.*;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree(int data) {
        this.root = new Node(data);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public List<List<Integer>> levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
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
                Node curr = queue.poll();
                subList.add(curr.data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public List<Integer> iterativePreOrder(Node node) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            traversal.add(curr.data);
            if (curr.right != null) stack.add(curr.right);
            if (curr.left != null) stack.add(curr.left);
        }
        return traversal;
    }

    public List<Integer> iterativeInOrder(Node node) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node root = node;
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                Node currNode = stack.pop();
                traversal.add(currNode.data);
                root = currNode.right;
            }
        }
        return traversal;
    }


    public List<Integer> iterativePostOrder(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
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

public class TreeTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        Node root = tree.root;
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        System.out.println("InOrder Traversal");
        tree.inOrder(root);
        System.out.println();
        System.out.println("PreOrder Traversal");
        tree.preOrder(root);
        System.out.println();
        System.out.println("PostOrder Traversal");
        tree.postOrder(root);
        System.out.println();
        System.out.println("LevelOrder Traversal");
        List<List<Integer>> traversal = tree.levelOrder(root);
        System.out.println(traversal);
        System.out.println("IterativePreOrder Traversal");
        List<Integer> preOrder = tree.iterativePreOrder(root);
        System.out.println(preOrder);
        System.out.println("IterativeInOrder Traversal");
        List<Integer> inOrder = tree.iterativeInOrder(root);
        System.out.println(inOrder);
        System.out.println("IterativePostOrder Traversal");
        List<Integer> postOrder = tree.iterativePostOrder(root);
        System.out.println(postOrder);

    }
}
