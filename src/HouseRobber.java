import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};
        int res = getMaxRobbery(houses);
        int res2 = getMaxRobberyInCircularHouses(houses);
        System.out.println("res=" + res);
        System.out.println("res2=" + res2);
    }

    public static int getMaxRobbery(int[] houses) {
        int houseCount = houses.length;
        int prev = houses[0];
        int prevPrev = 0;
        for (int index = 0; index < houseCount; index++) {
            int take = houses[index];
            if (index > 1) {
                take += prevPrev;
            }
            int skip = 0 + prev;

            int curr = Math.max(take, skip);
            prevPrev = prev;
            prev = curr;

        }
        return prev;
    }

    public static int getMaxRobberyInCircularHouses(int[] houses) {
        int houseCount = houses.length;

        if (houseCount == 1) {
            return houses[0];
        }

        int[] firstSetHouses = Arrays.copyOfRange(houses, 0, houseCount - 1);
        int[] secondSetHouses = Arrays.copyOfRange(houses, 1, houseCount);
        System.out.println("firstSetHouses=" + Arrays.toString(firstSetHouses));
        System.out.println("secondSetHouses=" + Arrays.toString(secondSetHouses));
        return Math.max(getMaxRobbery(firstSetHouses), getMaxRobbery(secondSetHouses));
    }
}
