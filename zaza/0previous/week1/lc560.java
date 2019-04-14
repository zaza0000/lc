import java.util.*;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1);
        int temp = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            temp += nums[i];
            ans += sum.getOrDefault(temp - k, 0);
            sum.put(temp, sum.getOrDefault(temp, 0) + 1);
        }
        return ans;
    }
}
