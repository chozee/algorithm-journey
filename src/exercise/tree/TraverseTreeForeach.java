package exercise.tree;

import class018.BinaryTreeTraversalIteration.TreeNode;

import java.util.Stack;

public class TraverseTreeForeach {
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            if (top.right != null) stack.push(top.right);
            if (top.left != null) stack.push(top.left);
        }
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                TreeNode top = stack.pop();
                System.out.printf("%s ", top.val);
                head = top.right;
            }
        }

        System.out.println("\ninorder end.");
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode head = root;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left != null && head != cur.left && head != cur.right) {
                stack.push(cur.left);
            }else if (cur.right != head && cur.right != null) {
                stack.push(cur.right);
            }else {
                head = stack.pop();
                System.out.printf("%s ", head.val);
            }
        }

        System.out.println("\npost order end...");
    }
}
