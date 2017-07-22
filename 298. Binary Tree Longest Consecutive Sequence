/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//Sample Solution Code
//对比我左右分开比，最后再取max，多设一个target变量省去了分左右这件事
//并且比左右的时候，我犯了一个错，移动了root
//总结： 下次遇到除了左右外都一样的function，可以参考这个题的处理方式

public class Solution {
    
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }// check it later
        helper(root, 0, root.val);
        return max;
    }
    
    private void helper(TreeNode root, int curr, int target) {
        if (root == null) {
            return;
        }
        
        if (root.val == target) {
            curr++;
        } else {
            curr = 1;
        }
        if (curr > max) {
            max = curr;
        }
        
        helper(root.left, curr, root.val + 1);
        helper(root.right, curr, root.val + 1);
    }
}

