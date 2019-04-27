package DFSandBacktrack;

import java.util.Arrays;

public class lc473 {
    // backtrack
    // index from 0 -> n-1 and from n-1 -> 0 is quite different!!!
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum%4 != 0)
            return false;
        int sideLength = sum/4;
        Arrays.sort(nums);
        if(nums[nums.length -1 ] > sideLength)
            return false;
        return backtrack(nums, new int[4], sideLength, nums.length - 1);
    }

    private boolean backtrack(int[] nums, int[] subSum, int sideLength, int index) {
        if (subSum[0] == sideLength && subSum[1] == sideLength &&
                subSum[2] == sideLength && subSum[3] == sideLength)
            return true;
        if(index < 0)
            return false;
        for (int i = 0; i < subSum.length; i++) {
            if(subSum[i] + nums[index] > sideLength || (i > 0 && subSum[i-1] == 0))
                continue;
            subSum[i] += nums[index];
            boolean res = backtrack(nums, subSum, sideLength, index-1);
            if(res == true)
                return true;
            subSum[i] -= nums[index];
        }
        return false;
    }
}

// try this later!!
//    public boolean makesquare(int[] nums) {
//        if (nums.length == 0) return false;
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum % 4 != 0) return false;
//        flags = new HashSet<>();
//
//        dfs(nums, 0, sum / 4);
//
//        int len = (int) Math.pow(2, nums.length);
//        boolean[] dp = new boolean[len];
//        dp[0] = true;
//        for (int num : flags) {
//            for (int i = dp.length - 1; i >= 0; i--) {
//                if (dp[i] && (num&i)==0) {
//                    dp[i | num] = true;
//                }
//            }
//        }
//        return dp[len - 1];
//    }
