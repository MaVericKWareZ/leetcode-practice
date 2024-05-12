import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveArray {
    public static void main(String[] args) {
        int[] arr = { 100, 102, 101, 100, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2 };
        int res = longestConsecutive(arr);
        int res1 = longestConsecutiveSorted(arr);
        System.out.println("res=" + res);
        System.out.println("res1=" + res1);

    }

    public static int longestConsecutiveSorted(int[] nums) {
        int size = nums.length;
        int longestLength = 0;
        int currLength = 0;
        int currSmall = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int index = 0; index < size; index++) {
            int currNum = nums[index];
            if (currNum == currSmall) {
                continue;
            } else if (currNum == currSmall + 1) {
                currLength++;
                currSmall = currNum;
            } else {
                currLength = 1;
                currSmall = currNum;
            }
            longestLength = Math.max(longestLength, currLength);
        }
        return longestLength;
    }

    public static int longestConsecutive(int[] nums) {
        int size = nums.length;
        int longestLength = 0;
        int currLength = 0;
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        for (int index = 0; index < size; index++) {
            int currNum = nums[index];
            int prevNum = currNum - 1;

            if (!numsSet.contains(prevNum)) {
                currLength = 1;
                int nextNum = currNum + 1;
                while (numsSet.contains(nextNum)) {
                    currLength++;
                    nextNum++;
                }
                longestLength = Math.max(longestLength, currLength);
            }
        }
        return longestLength;
    }
}