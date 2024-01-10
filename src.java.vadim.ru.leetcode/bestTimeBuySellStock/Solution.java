package bestTimeBuySellStock;

/**
 * Алгоритм прост, используется цикл с двумя офсетами - левый  - для покупки и правый для продажи. И переменная для хранения максимального значения разницы между продажей и покупкой.
 * Пока правый итерируется происходит проверка на то что значение под правым меньше чем значение под левым, т.е.
 * минимальное значение для покупки, левый передвигаем на правый офсет.
 * Паралельно с этим обновляем переменную с максимальной выгодой.
 * Далее возвращаем пременную профита.
 */
public class Solution {
    public static void main(String[] args) {
        int[] pr = new int[]{2,1,2,1,0,1,2};
        System.out.println(maxProfit(pr));
    }
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right =  0;
        int maxProfit = 0;
        while (right != prices.length) {
            int priceLeft = prices[left];
            int priceRight = prices[right];
            if (priceRight < priceLeft) {
                left = right;
            }
            if (priceRight - priceLeft > maxProfit) {
                maxProfit = priceRight - priceLeft;
            }
            right++;
        }
        return maxProfit;
    }
}
