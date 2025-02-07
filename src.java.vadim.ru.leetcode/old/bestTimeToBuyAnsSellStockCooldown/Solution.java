package old.bestTimeToBuyAnsSellStockCooldown;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static Map<Integer, Boolean> cache;

    public Solution() {
        cache = new HashMap<>();
    }
    public static void main(String[] args) {
        int [] pr = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(pr));
    }

    public static int maxProfit(int[] prices) {
       int f0 = 0;
       int f1 = -prices[0];
       int f = 0;
       for (int i = 1; i < prices.length; i++) {
           int current = Math.max(f0, f1 + prices[i]);
           f1 = Math.max(f1, f0 - prices[i]);
           f = f0;
           f0 = current;
       }
       return f0;
    }
}
