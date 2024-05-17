import java.util.*;

public class Solution {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currList = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        solve(candidates, target, currList, ans, 0);
        return ans.stream().toList();
    }

    public void solve(int[] candidates, int target, List<Integer> currList, Set<List<Integer>> ans, int index) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            Collections.sort(currList);
            ans.add(new ArrayList<>(currList));
            return;
        }

        int size = candidates.length;
        for (int i = index; i < size; i++) {
            currList.add(candidates[i]);
            solve(candidates, target - candidates[i], currList, ans, index);
            currList.remove(currList.size() - 1);
        }
    }
}


