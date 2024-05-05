import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        int res = climbStairs(n);
        System.out.println("res=" + res);
    }

    public static int climbStairs(int n) {
        int[] stepCountArray = new int[n + 1];
        Arrays.fill(stepCountArray, Integer.MAX_VALUE);
        stepCountArray[0] = 1;
        stepCountArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (stepCountArray[i] == Integer.MAX_VALUE) {
                stepCountArray[i] = stepCountArray[i - 1] + stepCountArray[i - 2];
            }
        }
        System.out.println(Arrays.toString(stepCountArray));

        return stepCountArray[n];
    }
}
