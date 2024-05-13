import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int n = 3;
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int res = getMaxTrainingPoints(n, points);
        System.out.println("res=" + res);
    }

    public static int getMaxTrainingPoints(int days, int[][] points) {
        int tasks = points[0].length;
        int[][] taskChoices = new int[days][tasks + 1];
        for (int day = 0; day < days; day++) {
            Arrays.fill(taskChoices[day], -1);
        }

        taskChoices[0][0] = Math.max(points[0][1], points[0][2]);
        taskChoices[0][1] = Math.max(points[0][0], points[0][2]);
        taskChoices[0][2] = Math.max(points[0][0], points[0][1]);
        taskChoices[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < days; day++) {
            for (int last = 0; last < tasks + 1; last++) {
                taskChoices[day][last] = 0;
                for (int task = 0; task < tasks; task++) {
                    if (task != last) {
                        int point = points[day][task] + taskChoices[day - 1][task];
                        taskChoices[day][last] = Math.max(taskChoices[day][last], point);
                    }
                }
            }
        }
        return taskChoices[days - 1][tasks];
    }

    public static int f(int day, int last, int[][] points, int[][] taskChoices) {
        if (day == 0) {
            int maxPoints = Integer.MIN_VALUE;
            for (int task = 0; task < points[0].length; task++) {
                if (task != last) {
                    maxPoints = Math.max(maxPoints, points[0][task]);
                }
            }
            return maxPoints;
        }
        if (taskChoices[day][last] != -1) {
            return taskChoices[day][last];
        }
        int maxPoints = Integer.MIN_VALUE;
        for (int task = 0; task < points[day].length; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points, taskChoices);
                maxPoints = Math.max(maxPoints, point);
            }
        }
        return taskChoices[day][last] = maxPoints;
    }
}