Solution 1:
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    TreeNode node = null;
    int minSum = Integer.MAX_VALUE;
    
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return root;
        }
        int curr = helper(root);
        if (curr < minSum) {
            minSum = curr;
            node = root;
        }
        findSubtree(root.left);
        findSubtree(root.right);
        return node;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return left + right + root.val;
    }
}

//Solution 2:
public class Solution {
    TreeNode node = null;
    int minSum = Integer.MAX_VALUE;
    
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return node;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum < minSum) {
            minSum = sum;
            node = root;
        }
        return sum;
    }
}