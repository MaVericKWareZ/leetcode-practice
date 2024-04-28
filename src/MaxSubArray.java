public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, -3, 4, -1, -2, 1, 5, 3};
        int sum = maxSubArray(nums);
//        System.out.println("sum = " + sum);
    }


    public static int maxSubArray(int[] nums) {
        int count = nums.length;
        if (count == 1) {
            return nums[0];
        } else {
            int maxSum = Integer.MIN_VALUE;
            int currSum = 0;
            int start = -1;
            int ansStart = -1;
            int ansEnd = -1;
            for (int i = 0; i < count; i++) {
                if (currSum == 0) {
                    start = i;
                }
                currSum += nums[i];
                if (currSum > maxSum) {
                    maxSum = currSum;
                    ansStart = start;
                    ansEnd = i;
                }
                if (currSum < 0) {
                    currSum = 0;
                }
            }
            for (int i = ansStart; i <= ansEnd; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();


            return maxSum;
        }
    }
}

