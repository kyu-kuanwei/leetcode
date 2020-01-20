import java.util.*;

public class LC102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> eachLevel = new LinkedList<Integer>(); // create a list to store each level element
            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
                eachLevel.add(node.val); // insert elements into each level list
            }
            res.add(eachLevel); // insert all level elements into results, which is a 2-dimension list
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        LC102_BinaryTreeLevelOrderTraversal test1 = new LC102_BinaryTreeLevelOrderTraversal();
        System.out.println(test1.levelOrder(tree));
    }
}
