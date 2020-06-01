package practice;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        int arr[] = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(arr);

        level_order_traversal(root);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i=1; i < preorder.length; i++) {
            int val = preorder[i];
            if (val < root.val)
                root.left = createBST(root.left, preorder[i]);
            else root.right = createBST(root.right, preorder[i]);
        }
        return root;
    }

    private static TreeNode createBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = createBST(root.left, val);
        else root.right = createBST(root.right, val);

        return root;
    }
    /*int val = preorder[i];
            if (val < tmp.val) {
        while (tmp.left!=null) {
            tmp = tmp.left;
        }
        tmp.left = new TreeNode(val);
    }*/
    public static void level_order_traversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()){
            TreeNode tmp = q.poll();
            if (tmp !=null){
                System.out.println(tmp.val);
                if (tmp.left != null)
                    q.offer(tmp.left);
                if (tmp.right != null)
                    q.offer(tmp.right);

            }
        }
    }
}
