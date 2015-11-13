package c4q.nyc.sufeiiz;

/**
 * Created by sufeizhao on 11/12/15.
 */
public class AppleStock {
    /* Suppose we could access yesterday's stock prices as a list, where:
    * The indices are the time in minutes past trade opening time, which was 9:30am local time.
    * The values are the price in dollars of Apple stock at that time.
    * So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.
    * Write an efficient function that takes stock_prices_yesterday and returns the best profit I could
    * have made from 1 purchase and 1 sale of 1 Apple stock yesterday. No "shorting"—you must buy before you sell.
    * You may not buy and sell in the same time step (at least 1 minute must pass).
    * */

    public static int getMaxProfit(int[] stockPrices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        int currentProfit;

        for (int i = 0; i < stockPrices.length - 1; i++) {
            if (stockPrices[i] < minPrice)
                minPrice = stockPrices[i];

            currentProfit = stockPrices[i] - minPrice;
            if (currentProfit > maxProfit)
                maxProfit = currentProfit;
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] stockPrice = new int[] {10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfit(stockPrice));
    }
 }
