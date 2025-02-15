package newStart.leetcode75;

import java.util.ArrayList;
import java.util.List;
//1431. Kids With the Greatest Number of Candies
public class GreatestNumberCandies {
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> result = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < candies.length; i++) {
                if (candies[i] > max) {
                    max = candies[i];
                }
            }
            for (int i = 0; i < candies.length; i++) {
                if ((extraCandies + candies[i]) >= max) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }
            return result;
        }
    }
}
