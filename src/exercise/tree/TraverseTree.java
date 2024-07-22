package exercise.tree;

import class017.BinaryTreeTraversalRecursion;

public class TraverseTree {
    public static void main(String[] args) {

        TreeNode head = buildTree();

        traverseTreeRecursionPreorder(head);
        System.out.println();
        System.out.println("先序遍历递归版");
    }

    public static TreeNode buildTree() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        return head;
    }

    public static void traverseTreeRecursionPreorder(TreeNode node) {
        if (node == null) {
            return ;
        }

        System.out.print(node.val + "->");

        traverseTreeRecursionPreorder(node.left);
        traverseTreeRecursionPreorder(node.right);
    }



    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
}
