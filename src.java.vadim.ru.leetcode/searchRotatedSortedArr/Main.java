package searchRotatedSortedArr;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2};
        int[] arr2 = new int[]{3, 1};
        System.out.println(search(arr, 1));
    }

    /**
     * 1. Устанавливаем стандартные переменные для бинарного поиска это левый, правый и середина.
     * 1.1. Цикл с условием пока левый меньше или равно правый
     * 2. Так как середина может быть в rotated массиве или в нормальной части массива,
     * нам нужно это определить, сравнив наш мид с последним элементом массива,
     * если мид больше, значит мы в ротайтетд массиве, если нет, значит в обычно порядке
     * 3. Следущий шаг, нам нужно понять и исключить ту часть массива где искать нет необходимости,
     * для этого
     * 3.1 сраниваем наш таргет с левой границей этой части. Если он меньше, значит в левой части элементы
     * только больше, нужно идти в правую часть от мида и переместить указатель мид вправо., и наооборот.
     * 3.2 также мб что таргет больше чем значение позиции мид, тогда при удовлетворении этого условия, левую позицию также сдвигаем в мид + 1.
     *
     * CСвоими словами, сначала определяем в какой части массива мид, далее если таргет меньше левого
     * края или больше мида, значит искать надо в правой части, если мы в оригинальной части (правой) тогда
     * если таргет больше правого края и меньше мида, в каждом уловие сдвигаем левый или правый оффсет
     * до мида + или - 1
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;

        while (low <= hight) {
            int mid = (low + hight) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[hight]) {
                if (target < nums[low] || target > nums[mid]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            } else {
                if (target > nums[hight] || target < nums[mid]) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}