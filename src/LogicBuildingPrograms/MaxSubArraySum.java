package LogicBuildingPrograms;

public class MaxSubArraySum {
    public static void main(String[] args) {

    }

    static int findMaxSum() {
        int[] nums = {10, 14, 152, 85, 0, 4, 52};
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //loginc is find max of current sum and num[i] + current sum
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
