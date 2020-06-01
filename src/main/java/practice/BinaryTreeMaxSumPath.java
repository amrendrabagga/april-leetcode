package practice;

public class BinaryTreeMaxSumPath {
    TreeNode root;
    public static void main(String[] args) {
        BinaryTreeMaxSumPath tree = new BinaryTreeMaxSumPath();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(1);
        tree.root.right.right = new TreeNode(-25);
        tree.root.right.right.left = new TreeNode(3);
        tree.root.right.right.right = new TreeNode(4);
        System.out.println("maximum path sum is : " +
                tree.maxPathSum(tree.root));

    }
    public int maxPathSum(TreeNode root) {
        Res result = new Res(Integer.MIN_VALUE);
        maxPathSumUtil(root, result);
        return result.val;
    }
    private int maxPathSumUtil(TreeNode root, Res result) {
        if (root == null) return 0;
        int left = maxPathSumUtil(root.left, result);
        int right = maxPathSumUtil(root.right, result);

        int maxStraight = Math.max(Math.max(left, right) + root.val, root.val);
        int maxCaseVal = Math.max(maxStraight, left+right+root.val);
        result.val = Math.max(maxCaseVal, result.val);

        return maxStraight;

    }
    static class Res{
        int val;
        Res(int val) {
            this.val = val;
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
