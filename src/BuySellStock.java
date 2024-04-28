public class BuySellStock {

    public static void main(String[] args) {
        int[] prices = new int[] { 2, 4, 1 };

        int profit = maxProfit(prices);
        System.out.println("profit=" + profit);

    }

    public static int maxProfit(int[] prices) {
        int days = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int currProfit = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i < days; i++) {
            if (currMin > prices[i]) {
                currMin = prices[i];
            }
            currProfit = prices[i] - currMin;

            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                System.out.println("maxProfit = " + maxProfit);
                System.out.println("buy=" + prices[i]);
                System.out.println("sell=" + prices[i + 1]);
            }
        }
        return Math.max(maxProfit, 0);
    }
}
