import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaximumDepthofBinaryTree {
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

    public static void main(String[] args) {
        LC104_MaximumDepthofBinaryTree test = new LC104_MaximumDepthofBinaryTree();
        TreeNode test1 = new TreeNode(3);
        test1.left = new TreeNode(9);
        test1.right = new TreeNode(20);
        test1.right.left = new TreeNode(15);
        test1.right.right = new TreeNode(7);
        System.out.println(test.maxDepthBFS(test1));
    }
}
