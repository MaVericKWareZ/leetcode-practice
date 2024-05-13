import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 1, 2};
        List<List<Integer>> res = threeSum(arr);
        List<List<Integer>> res1 = threeSumSorted(arr);

        System.out.println("res=" + res);
        System.out.println("res1=" + res1);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> threeSumSet = new HashSet<>();
        int size = nums.length;
        for (int firstPos = 0; firstPos < size; firstPos++) {
            HashSet<Integer> tempSet = new HashSet<>();
            for (int secondPos = firstPos + 1; secondPos < size; secondPos++) {
                int thirdNum = 0 - (nums[firstPos] + nums[secondPos]);
                if (tempSet.contains(thirdNum)) {
                    List<Integer> threeSunList = new ArrayList<>();
                    threeSunList.add(nums[firstPos]);
                    threeSunList.add(nums[secondPos]);
                    threeSunList.add(thirdNum);
                    Collections.sort(threeSunList);
                    threeSumSet.add(threeSunList);
                }
                tempSet.add(nums[secondPos]);
            }
        }
        return new ArrayList<>(threeSumSet);
    }

    public static List<List<Integer>> threeSumSorted(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> threeSumList = new ArrayList<>();
        int size = nums.length;
        for (int firstPos = 0; firstPos < size; firstPos++) {
            if (firstPos > 0 && nums[firstPos] == nums[firstPos - 1])
                continue;
            int left = firstPos + 1;
            int right = size - 1;
            while (left < right) {
                int sum = nums[firstPos] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> threeSum = new ArrayList<>();
                    threeSum.add(nums[firstPos]);
                    threeSum.add(nums[left]);
                    threeSum.add(nums[right]);
                    threeSumList.add(threeSum);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                }
            }
        }
        return threeSumList;
    }

}
