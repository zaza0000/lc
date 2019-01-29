import java.util.*;

public class lc215 {
    // stack
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>();
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }

    // quick select
    public int findKthLargest2(int[] nums, int k) {
        return helper(nums, k-1, 0, nums.length-1);
    }

    private int helper(int[] nums, int k, int left, int right){
        if(left == right)
            return nums[left];
        int pivot = nums[left];
        int l = left;
        int r = right;
        while(l < r){
            while(l < r && pivot >= nums[r]){
                r--;
            }
            if(l < r && pivot < nums[r]){
                nums[l] = nums[r];
                l++;
            }
            while(l < r && pivot <= nums[l]){
                l++;
            }
            if(l < r && pivot > nums[l]){
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = pivot;
        if(k < l){
            return helper(nums, k, left, l - 1);
        }
        if(k > r){
            return helper(nums, k, r + 1, right);
        }
        return nums[l];
    }
}
