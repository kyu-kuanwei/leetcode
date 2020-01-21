import java.util.LinkedList;
import java.util.Queue;

public class LC993_CousinsBinaryTree {
    public boolean isCousins(TreeNode root, int A, int B) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isAexist = false;
            boolean isBexist = false;
            while (size > 0) {
                TreeNode node = q.poll();
                if(node.val == A)   isAexist = true;
                if(node.val == B)   isBexist = true;

                if(node.left != null && node.right != null){ //find out if they have same parent or not.
                    if(node.left.val == A && node.right.val == B)   return false;
                    if(node.left.val == B && node.right.val == A)   return false;
                }
                if (node.left != null)  q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                size--;
            }
            if (isAexist && isBexist) return true;
            // if both A and B are in the same queue, which means they are in the same level of the binary tree
            else if (isAexist || isBexist) return false;
            // if either A or B in the queue, means they are not in the same level
        }
        return false;
    }

    public static void main(String[] args) {
        LC993_CousinsBinaryTree test = new LC993_CousinsBinaryTree();
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.right = new TreeNode(4);
        test1.right.right = new TreeNode(5);
        System.out.println(test.isCousins(test1, 5,4));
        /*
                1
               / \
              2   3
               \   \
                4   5
         */
    }
}
