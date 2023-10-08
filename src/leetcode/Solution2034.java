package leetcode;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 2034. 股票价格波动
 */
public class Solution2034 {
    class StockPrice {
        int maxTimestamp;
        HashMap<Integer, Integer> timePriceMap;
        TreeMap<Integer, Integer> prices;

        public StockPrice() {
            maxTimestamp = 0;
            timePriceMap = new HashMap<Integer, Integer>();
            prices = new TreeMap<Integer, Integer>();
        }

        public void update(int timestamp, int price) {
            maxTimestamp = Math.max(maxTimestamp, timestamp);
            int prevPrice = timePriceMap.getOrDefault(timestamp, 0);
            timePriceMap.put(timestamp, price);
            if (prevPrice > 0) {
                prices.put(prevPrice, prices.get(prevPrice) - 1);
                if (prices.get(prevPrice) == 0) {
                    prices.remove(prevPrice);
                }
            }
            prices.put(price, prices.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return timePriceMap.get(maxTimestamp);
        }

        public int maximum() {
            return prices.lastKey();
        }

        public int minimum() {
            return prices.firstKey();
        }
    }
}
