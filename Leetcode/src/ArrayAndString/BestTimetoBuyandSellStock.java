package ArrayAndString;
/**
 * 121. Best Time to Buy and Sell Stock
 * @author zg55
 *Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Hide Company Tags Microsoft Bloomberg Uber Facebook
Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Maximum Subarray (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock III (H) Best Time to Buy and Sell Stock IV (M) Best Time to Buy and Sell Stock with Cooldown

 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min=Integer.MAX_VALUE;
        int p=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++) {
            min=min<prices[i]?min:prices[i];
            p=p>prices[i]-min?p:prices[i]-min;
        }
        return p;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
