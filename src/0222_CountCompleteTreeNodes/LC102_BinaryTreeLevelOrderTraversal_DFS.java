public int solution_DFS(TreeNode root) {
    int ans = 0;
    if(root == null)
        return 0;
    if(root.left != null)
        ans = 1 + solution_DFS(root.left);
    if(root.right != null)
        ans = 1 + solution_DFS(root.right);
    return ans;
}
