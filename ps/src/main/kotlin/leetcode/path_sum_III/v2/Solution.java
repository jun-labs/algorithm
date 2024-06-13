package leetcode.path_sum_III.v2;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

class Solution {
    public int pathSum(
        TreeNode root,
        int targetSum
    ) {
        if (root == null) {
            return 0;
        }
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(
        TreeNode node,
        long targetSum
    ) {
        if (node == null) {
            return 0;
        }
        long count = node.value == targetSum ? 1 : 0;
        count += dfs(node.left, targetSum - node.value);
        count += dfs(node.right, targetSum - node.value);
        return (int) count;
    }
}
