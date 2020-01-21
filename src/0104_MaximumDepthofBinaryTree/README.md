1. The trivial one, **Recursion** version:
```Java
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
```
2. The iteration version:
   - DFS:
   - BFS:
   ```java
   public int maxDepthBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)    return 0;
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size --;
            }
            count ++;
        }
        return count;
    }
   ```
