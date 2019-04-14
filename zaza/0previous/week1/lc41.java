public class lc41 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null)
            return 1;

        for(int i = 0; i < nums.length; i++){
            while(nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[nums[i] -1]){
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length + 1;
    }
}
