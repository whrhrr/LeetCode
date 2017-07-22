public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
     
    TreeNode node = null;
    ResultType maxResult = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return node;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        // if (root.left == null && root.right == null) {
        //     return new ResultType(root.val, 1);
        // }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        ResultType result = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1);
        if (node == null || result.sum * maxResult.size > maxResult.sum * result.size) {
            node = root;
            maxResult = result;
        }
        return result;
    }
}

class ResultType {
    public int sum;
    public int size;
    ResultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}