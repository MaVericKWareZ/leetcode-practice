import java.util.Arrays;

public class FindOptimalBlockToLive {
    public static void main(String[] args) {
        int[] reqs = {1, 2, 3};
        int[][] blocks = {{0, 1, 0}, {1, 0, 0}, {1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        int res = findOptimalBlockToLive(blocks, reqs);
        System.out.println("res=" + res);
    }

    public static int findOptimalBlockToLive(int[][] blocks, int[] reqs) {
        int[][] blockDistancesArray = new int[blocks.length][reqs.length + 1];
        int optimalIndex = -1;
        int optimalValueToWalk = Integer.MAX_VALUE;
        int blocksCount = blocks.length;
        int reqsCount = reqs.length;

        for (int blockIndex = 0; blockIndex < blocksCount; blockIndex++) {
            Arrays.fill(blockDistancesArray[blockIndex], Integer.MAX_VALUE);
        }

        for (int reqIndex = 0; reqIndex < reqsCount; reqIndex++) {
            blockDistancesArray[0][reqsCount] = 0;
            if (blocks[0][reqIndex] == 1) {
                blockDistancesArray[0][reqIndex] = 0;
            }
            blockDistancesArray[0][reqsCount] = Math.max(blockDistancesArray[0][reqsCount],
                    blockDistancesArray[0][reqIndex]);
        }
        if (blockDistancesArray[0][reqsCount] <= optimalValueToWalk) {
            optimalValueToWalk = blockDistancesArray[0][reqsCount];
            optimalIndex = 0;
        }

        for (int blockIndex = 1; blockIndex < blocksCount; blockIndex++) {
            blockDistancesArray[blockIndex][reqsCount] = 0;
            for (int reqIndex = 0; reqIndex < reqsCount; reqIndex++) {
                if (blocks[blockIndex][reqIndex] == 1) {
                    blockDistancesArray[blockIndex][reqIndex] = 0;
                } else {
                    if (blockDistancesArray[blockIndex - 1][reqIndex] != Integer.MAX_VALUE) {
                        blockDistancesArray[blockIndex][reqIndex] = Math.min(blockDistancesArray[blockIndex][reqIndex],
                                blockDistancesArray[blockIndex - 1][reqIndex] + 1);
                    }
                }
                blockDistancesArray[blockIndex][reqsCount] = Math.max(blockDistancesArray[blockIndex][reqsCount],
                        blockDistancesArray[blockIndex][reqIndex]);
            }
        }

        for (int blockIndex = blocksCount - 2; blockIndex >= 0; blockIndex--) {
            for (int reqIndex = 0; reqIndex < reqsCount; reqIndex++) {
                if (blocks[blockIndex][reqIndex] == 1) {
                    blockDistancesArray[blockIndex][reqIndex] = 0;
                } else {
                    if (blockDistancesArray[blockIndex + 1][reqIndex] != Integer.MAX_VALUE) {
                        blockDistancesArray[blockIndex][reqIndex] = Math.min(blockDistancesArray[blockIndex][reqIndex],
                                blockDistancesArray[blockIndex + 1][reqIndex] + 1);
                    }
                }
                if (blockDistancesArray[blockIndex][reqsCount] == Integer.MAX_VALUE) {
                    blockDistancesArray[blockIndex][reqsCount] = 0;
                }
                blockDistancesArray[blockIndex][reqsCount] = Math.max(blockDistancesArray[blockIndex][reqsCount],
                        blockDistancesArray[blockIndex][reqIndex]);
            }
            if (blockDistancesArray[blockIndex][reqsCount] < optimalValueToWalk) {
                optimalValueToWalk = blockDistancesArray[blockIndex][reqsCount];
                optimalIndex = blockIndex;
            }

        }

        System.out.println(Arrays.deepToString(blockDistancesArray));

        return optimalIndex;
    }
}