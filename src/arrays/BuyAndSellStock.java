package arrays;

/*- Given, an array with prices of a stock for upcoming n days.
 *  We can buy the stock on any day and sell on any upcoming days.
 *  WAP to return the maximum profit.
 *  
 *  I/P: arr[] = {1, 5, 3, 1, 2, 8}
 *  O/P: 11 (Buy on day 1, sell on day 2. Buy on day 4, sell on day 6).
 */
public class BuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = { 1, 5, 3, 8, 12 };
		System.out.println(getMaximumProfit(prices));
	}

	// Valley Peak Approach: Cumulatively add profits
	private static int getMaximumProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				profit += (prices[i] - prices[i - 1]);
		}
		return profit;
	}

}
