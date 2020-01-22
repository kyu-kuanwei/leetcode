public int BFS(TreeNode root) { 
    Queue<TreeNode> q = new LinkedList<>();
    if(root == null)    
      return 0;
    q.offer(root);
    int res = 0;
    while(!q.isEmpty()) {
        int size = q.size();
        for(int i = 0 ; i < size ; i++) {
            TreeNode node = q.poll();
            res++;
            if(node.left != null)   
                q.offer(node.left);
            if(node.right != null)  
                q.offer(node.right);
        }
    }
    return res;
}
