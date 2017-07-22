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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            return inorderSuccessor(root.left, p) == null ? root : inorderSuccessor(root.left, p);
        }
    }
}


// Predecessor
// public TreeNode predecessor(TreeNode root, TreeNode p) {
//   if (root == null)
//     return null;

//   if (root.val >= p.val) {
//     return predecessor(root.left, p);
//   } else {
//     TreeNode right = predecessor(root.right, p);
//     return (right != null) ? right : root;
//   }
// }
