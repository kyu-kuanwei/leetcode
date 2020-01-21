1. The trivail one, **Recursion** version:
```Java
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
```
2. The iteration version:
   - DFS:
   - BFS:
