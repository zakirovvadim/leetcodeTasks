package old.notForYandex.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Алгоритм следующий:
 * Похож на 2Сум задачу. Создаем цикл где ткущая итерация это левый-левый офсет как a-число при сложении а + b + с
 * b и c - левый и правый офсеты для движения внутри цикла while, чтобы проверить возможность получения результата 0,
 * т.е. проверка каждой комбинации. А именно, если результат при тройном сложении получается больше 0, сдвигаем правый офсет влево
 * наоборот, левый офсет вправо. Если равен, значит мы полчили ноль и эту комбинацию из трех чисел мы можем сохранить
 *  в отдельный лист, а также свдинуть офсет левый в право и проверить в еще вложенном цикле, есть ли далее повторяющиеся элементы.
 *  Т.е. в цикле с условием что левый офсет и левый - 1 равный друг другу, значит двигаем наш левый офсет вправо, до тех пор пока не будет другое число
 *  не равное левому офсету или мы не подойдем к границе правого офсета.
 *
 *  Note: мы два раза можем пропустить итерацию, в первом случаее на верхнем уровне форича, второй раз во втором while.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) { // форич где итерация это левый-левый офсет
            int iter = nums[i];
            if (i != 0 && iter == nums[i - 1]) continue; // на итерации проверяем, что следующий элемент не равен предыдущему, чтобы не считать заново и пропускаем
            int leftOffset = i + 1; // b = leftOffset
            int rightOffset = nums.length - 1; // c = rightOffset
            while (leftOffset < rightOffset) {
                int leftValue = nums[leftOffset]; // значение для b
                int rightValue = nums[rightOffset]; // значение для c
                int threeSum = iter + leftValue + rightValue; // складываем a + b + c
                if (threeSum > 0) {// условия сдвига офссетов
                    rightOffset = rightOffset - 1;
                } else if (threeSum < 0) {// условия сдвига офссетов
                    leftOffset = leftOffset + 1;
                } else { // результат 0, сохраняем комбинацию и првоеряем что следующие не те же числа
                    resultList.add(List.of(iter, leftValue, rightValue));
                    leftOffset++;
                    while (nums[leftOffset] == nums[leftOffset - 1] && leftOffset < rightOffset) {// сдвигаем левый офсет до тех пор, пока не перестанут повторять числа
                        leftOffset = leftOffset + 1;
                    }
                }
            }
        }
        return resultList;
    }

}
