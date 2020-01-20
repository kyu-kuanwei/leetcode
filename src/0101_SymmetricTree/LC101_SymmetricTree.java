public class LC101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    public boolean helper(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null)    return t1 == t2;

        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }

    public static void main(String[] args) {
        LC101_SymmetricTree test = new LC101_SymmetricTree();
        TreeNode test1 = new TreeNode(2);
        test1.left = new TreeNode(4);
        test1.right = new TreeNode(4);
        test1.left.left = new TreeNode(6);
        test1.left.right = new TreeNode(6);
        test1.right.left = new TreeNode(8);
        test1.right.right = new TreeNode(8);

        System.out.println(test.isSymmetric(test1));
    }
}
