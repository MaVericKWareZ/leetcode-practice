import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = getAllPermutations(nums);
        System.out.println("permutations = " + permutations);
    }

    public static List<List<Integer>> getAllPermutations(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        List<Integer> currPermutation = new ArrayList<>();
        Map<Integer, Boolean> pickMap = new HashMap<>();
        solve(nums, allPermutations, currPermutation, pickMap);
        return allPermutations;
    }

    public static void solve(int[] nums, List<List<Integer>> allPermutations, List<Integer> currPermutation, Map<Integer, Boolean> pickMap) {
        int size = nums.length;

        if (currPermutation.size() == size) {
            allPermutations.add(new ArrayList<>(currPermutation));
            return;
        }

        for (int curr : nums) {
            if (!pickMap.getOrDefault(curr, Boolean.FALSE)) {
                currPermutation.add(curr);
                pickMap.put(curr, Boolean.TRUE);
                solve(nums, allPermutations, currPermutation, pickMap);
                currPermutation.remove(currPermutation.size() - 1);
                pickMap.put(curr, Boolean.FALSE);
            }
        }
    }

}
