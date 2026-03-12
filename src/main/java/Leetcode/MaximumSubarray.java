package Leetcode;

public class MaximumSubarray {
//    nums = [5, 4, -1, 7, 8]
//    [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            if (currentSum < 0){
                currentSum = 0;
            }
            currentSum = currentSum + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
