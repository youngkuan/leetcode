package easy.question437;

/**
 * Path Sum III
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must
 * go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * @author yangkuan
 */
public class Solution {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 首先根节点往下，之后其左右子节点也是需要往下找
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return goDownwards(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    private int goDownwards(TreeNode root,int sum){
        int count = 0;
        if(root==null){
            return count;
        }
        if(root.val==sum) count++;
        return count
                +goDownwards(root.left,sum-root.val)
                +goDownwards(root.right,sum-root.val);
    }
}