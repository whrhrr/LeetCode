/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        return helper(root);
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int curr = 1;
        
        if (root.left != null && root.val + 1 == root.left.val) {
            left++;
            if (left > curr) {
                curr = left;
            }
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            right++;
            if (riht > curr) {
                curr = right;
            }
        }
        if (curr > max) {
            max = curr;
        }
        return max;
    }
}