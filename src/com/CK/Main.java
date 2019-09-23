package com.CK;

public class Main {

    public static void main(String[] args) {
        int[] nums = {-1, 4, -2, 3, -2, 3};
        new Solution().maxSubArray(nums, 2);
    }
}

class Solution {
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k > nums.length) return 0;
        int n = nums.length;
        int[][] local = new int[n + 1][k + 1];
        int[][] global = new int[n + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            local[j - 1][j] = Integer.MIN_VALUE;//前j－1个元素不可能找到不重叠的j个子数组，因此初始化为最小值，以防后面被取到
            for (int i = j; i <= n; i++) {
                local[i][j] = Math.max(local[i - 1][j], global[i - 1][j - 1]) + nums[i - 1];
                if (i == j)
                    global[i][j] = local[i][j];
                else
                    global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[n][k];
    }
}