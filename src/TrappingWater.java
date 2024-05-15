public class TrappingWater {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = getTrappedWater(heights);
        System.out.println("trappedWater = " + trappedWater);
    }

    public static int getTrappedWater(int[] heights) {
        int size = heights.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int trappedWater = 0;


        left[0] = heights[0];
        for (int index = 1; index < size; index++) {
            left[index] = Math.max((heights[index]), left[index - 1]);
        }
        right[size - 1] = heights[size - 1];
        for (int index = size - 2; index >= 0; index--) {
            right[index] = Math.max(heights[index], right[index + 1]);
        }

        for (int index = 0; index < size; index++) {
            int maxHeight = Math.min(right[index], left[index]);
            trappedWater += (maxHeight - heights[index]);
        }

        return trappedWater;
    }
}
