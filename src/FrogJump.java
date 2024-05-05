import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] jumpHeights = { 30, 10, 60, 10, 60, 50 };
        int res = minEnergyRequired(jumpHeights);
        int k = 2;
        int res2 = minEnergyRequiredWithKJumps(jumpHeights, k);
        System.out.println("res=" + res);
        System.out.println("res2=" + res2);
    }

    public static int getEnergyReq(int h1, int h2, int[] jumpHeights) {
        System.out.println("h1=" + h1 + ", h2=" + h2);
        int energy = Math.abs(jumpHeights[h1] - jumpHeights[h2]);
        System.out.println("energy=" + energy);
        return energy;
    }

    public static int minEnergyRequired(int[] jumpHeights) {
        int height = jumpHeights.length;
        int[] minEnergyArray = new int[height];
        Arrays.fill(minEnergyArray, -1);
        minEnergyArray[0] = 0;
        for (int i = 1; i < height; i++) {
            int first = minEnergyArray[i - 1] + getEnergyReq(i, i - 1, jumpHeights);
            int second = Integer.MAX_VALUE;
            if (i > 1) {
                second = minEnergyArray[i - 2] + getEnergyReq(i, i - 2, jumpHeights);
            }
            minEnergyArray[i] = Math.min(first, second);
        }

        return minEnergyArray[height - 1];
    }

    public static int minEnergyRequiredWithKJumps(int[] jumpHeights, int k) {
        int height = jumpHeights.length;
        int minEnergyArray[] = new int[height];
        Arrays.fill(minEnergyArray, -1);
        minEnergyArray[0] = 0;
        for (int i = 1; i < height; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int currEnergy = minEnergyArray[i - j] + getEnergyReq(i, i - j, jumpHeights);
                    System.out.println("currEnergy=" + currEnergy);
                    minEnergy = Math.min(minEnergy, currEnergy);
                }
            }
            minEnergyArray[i] = minEnergy;
            System.out.println(Arrays.toString(minEnergyArray));
        }
        return minEnergyArray[height - 1];
    }
}
