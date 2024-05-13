import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 9;
        int res = subArraySumK(arr, k);
        System.out.println("res=" + res);
    }

    public static int subArraySumK(int[] nums, int k) {
        int size = nums.length;
        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        prefixSumCountMap.put(0, 1);
        for (int i = 0; i < size; i++) {
            currSum += nums[i];
            int complement = currSum - k;
            if (prefixSumCountMap.containsKey(complement)) {
                count += prefixSumCountMap.get(complement);
            }
            prefixSumCountMap.put(currSum, prefixSumCountMap.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}

// arr 1 2 3 4 5
// sum 4

// 1 0 0 0 0 0 0