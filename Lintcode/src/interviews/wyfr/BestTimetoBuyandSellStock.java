package interviews.wyfr;
/**
 * 
 * @author zg55
 *149. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
Given array [3,2,3,1,2], return 1.


 */
public class BestTimetoBuyandSellStock {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        
        int mi = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            mi = Math.min(mi, prices[i]);
            profit = Math.max(profit, prices[i] - mi);
        }
        return profit;
    }

}
