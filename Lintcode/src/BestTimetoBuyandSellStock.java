/**
 * 
 * @author jguan
 *Back
149. Best Time to Buy and Sell Stock
Description
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Have you met this question in a real interview?  
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
        if(prices == null || prices.length < 2) return 0;
        int maxProfit = 0;
        int maxPrice = 0;
        for(int i = prices.length - 1; i > 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            int profit = maxPrice - prices[i-1];
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
