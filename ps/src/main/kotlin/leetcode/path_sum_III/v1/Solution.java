package leetcode.path_sum_III.v1;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}

public class Solution {
    public int pathSum(
        TreeNode root,
        int targetSum
    ) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(
        TreeNode node,
        long currentSum,
        int targetSum,
        Map<Long, Integer> counts
    ) {
        if (node == null) {
            return 0;
        }

        currentSum += node.value;
        int pathCount = counts.getOrDefault(currentSum - targetSum, 0);
        counts.put(currentSum, counts.getOrDefault(currentSum, 0) + 1);

        pathCount += dfs(node.left, currentSum, targetSum, counts);
        pathCount += dfs(node.right, currentSum, targetSum, counts);

        counts.put(currentSum, counts.get(currentSum) - 1);
        return pathCount;
    }
}
