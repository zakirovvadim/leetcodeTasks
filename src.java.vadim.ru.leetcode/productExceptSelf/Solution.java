package productExceptSelf;

/**
 * Алгоритм подразумевает два прохода туда и обратно по массиву с использованием отдельной переменной для аккумуляции
 * произведения и результирующего массива.
 * Создаем переменную, в цикле сохраняем в результирующую переменную по тем же индексом значение аккумулятора.
 * После аккумултору присваиваем произведение его же на значение из намс по итерации.
 *
 * В следуюущем цикле в обратном порядке, в результирующем массиве присваиваем произведение нового аккумулятора
 * на значение по текущему индексу и перезаписываем значение в результирующем массиве.
 * Перезаписываем аккумулятор на произведение его же и значение из намс по итерации.
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int accumulator = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = accumulator;
            accumulator = accumulator * nums[i];
        }
        int accumTwo = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = accumTwo * result[i];
            accumTwo = accumTwo * nums[i];
        }
        return result;
    }
}
