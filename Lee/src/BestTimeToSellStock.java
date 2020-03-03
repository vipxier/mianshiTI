
public class BestTimeToSellStock {
	public static int maxProfit(int[] prices) {
		if (prices == null) {
			return 0;
		}
		int maxProfit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			if (findMaxElement(prices, i) - prices[i] > maxProfit) {
				maxProfit = findMaxElement(prices, i) - prices[i];
			}
		}

		return maxProfit;
	}

	private static int findMaxElement(int[] array, int startPosition) {
		int resultPosition = startPosition;
		for (int i = startPosition + 1; i < array.length; i++) {
			if (array[i] > array[resultPosition]) {
				resultPosition = i;
			}
		}

		return array[resultPosition];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 6, 8, 2, 3, 6, 32, 1, 5, 8, 22 };

		System.out.println(maxProfit(prices));
	}
}
