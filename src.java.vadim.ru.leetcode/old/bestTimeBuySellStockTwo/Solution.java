package old.bestTimeBuySellStockTwo;

/**
 * Алгоритм схож что и в первой old.bestTimeBuySellStock, толкьо на этот раз нам надо вернуть сумму наших выгод.
 * Для этого заводим еще одну переменную результирующую, и другая макПрофит несет всебе выгоду на один раз.
 * В цикле если правый офсет минус левый больше чем макс профит, присваиваем максимлаьный профит как разница между продажей и покупкой,
 * этот профит также присваиваем результирующей переменной. Далее обнуляем максПрофит.
 */
public class Solution {
    public static void main(String[] args) {
        int[] pr = new int[]{2,1,2,1,0,1,2};
        System.out.println(maxProfit(pr));
    }
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right =  0;
        int resultMaxProfit = 0;
        int maxProfit = 0;
        while (right != prices.length) {
            int priceLeft = prices[left];
            int priceRight = prices[right];
            if (priceRight < priceLeft) {
                left = right;
            }
            if (priceRight - priceLeft > maxProfit) {
                maxProfit += priceRight - priceLeft; // посчитали выгоду на ткущий рост
                resultMaxProfit += maxProfit;// суммировали с результирующей выгодой
                maxProfit = 0;// обнулили текущий счетчик выгоды, для последующего определения при росте.
                left = right;// сдвинули минимальную сумму покупки на сумму продажи, чтобы в следующую выгодную покупку сместить офсет.
            }
            right++;
        }
        return resultMaxProfit;
    }
}
