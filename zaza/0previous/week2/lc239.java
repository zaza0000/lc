import java.util.*;

public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        if(size == 0)
            return new int[0];
        int[] ans = new int[size-k+1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<size; i++){
            while (!dq.isEmpty() && dq.peek()<i-k+1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                ans[index++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}
