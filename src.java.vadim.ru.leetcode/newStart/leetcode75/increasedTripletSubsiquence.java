package newStart.leetcode75;
/*
1. Сначала идёт проверка на длину массива. Если массив пуст или в нём меньше трёх элементов, возвращаем `false`, так как невозможно сформировать возрастающую тройку.
2. Переменные и изначально инициализируются максимально возможными значениями. В них будут храниться текущие кандидаты на первую и вторую минимальные цифры потенциальной возрастающей последовательности. `fMin``sMin`
3. При обходе массива для каждого элемента проверяется:
    - Если больше, чем уже найденный второй минимальный , значит существует элемент, идущий после , который больше — это говорит о наличии возрастающей тройки (возвращаем `true`). `i``sMin``sMin``sMin`
    - Если меньше или равен , значит нужно обновить (мы нашли новый, более маленький потенциальный первый элемент). `i``fMin``fMin`
    - Иначе (если больше, чем , но при этом не больше ), мы обновляем как второе минимальное число. `i``fMin``sMin``sMin`

`i`
4. Если в процессе обхода не встретилось ситуации, когда элемент оказался больше , метод возвращает `false`. `sMin`

Таким образом, идея алгоритма — за один проход по массиву определить, можем ли мы «построить» возрастающую подпоследовательность из трёх элементов. Если это удаётся, метод возвращает `true`, в противном случае — `false`.

 */
public class increasedTripletSubsiquence {

    public static void main(String[] args) {
        int[] arr1 = new int[]{5,1,6};
        int[] arr2 = new int[]{5,4,3,2,1};
        int[] arr3 = new int[]{2,1,5,0,4,6};
        int[] arr4 = new int[]{20,100,10,12,5,13};
        var bool1 = increasingTriplet(arr1);
        var bool2 = increasingTriplet(arr2);
        var bool3 = increasingTriplet(arr3);
        var bool4 = increasingTriplet(arr4);

        System.out.println(bool1);
        System.out.println(bool2);
        System.out.println(bool3);
        System.out.println(bool4);
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length < 3) return false;
        int fMin = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;
        for (int i : nums) {
           if (i > sMin) {
               return true;
           }
           if(i <= fMin) {
               fMin = i;
           } else {
               sMin = i;
           }
        }
        return false;
    }

}
