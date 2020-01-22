public int solution_DFS(TreeNode root) {
    int ans = 0;
    if(root == null)
        return 1;
    if(root.left != null)
        ans += solution_DFS(root.left);
    if(root.right != null)
        ans += solution_DFS(root.right);
    return ans;
}
