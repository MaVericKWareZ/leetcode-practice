import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
//        List<Integer> unique = removeDuplicates(arr);
//        if (unique.size() == 0) {
//            System.out.println("No elements in array");
//        }
//        System.out.println("unique = " + unique);

        rotate(nums, 2);
    }

    public static List<Integer> removeDuplicates(int[] arr) {
        HashSet<Integer> visited = new HashSet<>();
        int size = arr.length;
        if (size == 0) {
            return Collections.emptyList();
        }
        for (int num : arr) {
            visited.add(num);
        }

        return visited.stream().toList();
    }

    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        int pivot = 0;
        System.out.println("nums = " + Arrays.toString(nums));

        for(int i = k+1; i < size; i++){
            swap(nums, i, pivot);
            pivot--;
        }

        System.out.println("nums = " + Arrays.toString(nums));


        pivot = k % size;
        for(int i = k+1 ; i < k + (size-k)/2; i++){
            swap(nums, i, pivot);
            pivot--;
        }

        System.out.println("nums = " + Arrays.toString(nums));


        pivot = size - 1;
        for(int i = 0; i < size/2 ; i++){
            swap(nums, i, pivot);
            pivot--;
        }

        System.out.println("nums = " + Arrays.toString(nums));
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
