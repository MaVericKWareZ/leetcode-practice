import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = { 2, 7, 9, 3, 1 };
        int res = getMaxRobbery(houses);
        System.out.println("res=" + res);
    }

    public static int getMaxRobbery(int[] houses) {
        int houseCount = houses.length;
        int[] maxRobberyValues = new int[houseCount];
        Arrays.fill(maxRobberyValues, 0);
        int maxRobbery = Integer.MIN_VALUE;
        for (int index = 0; index < houseCount; index++) {

            int currRoberry = houses[index];
            maxRobberyValues[index] += currRoberry;
            maxRobbery = Math.max(maxRobbery, maxRobberyValues[index]);
            int nextHouseIndex = index + 2;
            if (nextHouseIndex < houseCount) {
                maxRobberyValues[nextHouseIndex] += maxRobbery;
                maxRobbery = Math.max(maxRobbery, maxRobberyValues[nextHouseIndex]);
            }

            System.out.println("maxRobbery=" + maxRobbery + ", maxRobberyValues=" + Arrays.toString(maxRobberyValues));

        }
        System.out.println(Arrays.toString(maxRobberyValues));
        return maxRobbery;
    }
}
