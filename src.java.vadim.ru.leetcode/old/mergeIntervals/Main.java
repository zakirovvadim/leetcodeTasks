package old.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Алгоритм
 * Для начала надо отсортировать матрицу по первому индексу каждого внутрненненго массива.
 * Далее создаем результирующий лист, куда заранее можно положить первый лемент и итерацию начинать со второго элемента
 * В итерации достаем последний элемент предыдущего массива и сравнвиаем его с первым элементом текущей итерации
 * Если последний элемент предыдущего больше или равен значи это пересечение и можно смержить, для этого у предыдущего элемента
 * достаем второе число и перезаписываем на максимальное между ним и вторым числом из текущей итерации.
 * Если мерж не нужен, просто добавляем массив текущей итерации в результирующий листю
 */
public class Main {
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {0, 2}, {3,5}};
        int[][] merge = merge(intervals);
        System.out.println(merge);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int lastEnd = resultList.get(resultList.size() - 1)[1]; // взяли второе число предыдущего массива
            if (intervals[i][0] <= lastEnd) { // сравниваем последнйи предыдущего с первым текущего т.е. проверка необходимсоти смержить
                resultList.get(resultList.size() - 1)[1] = Math.max(lastEnd,intervals[i][1]); //если да перезаписываем последний элемент у предыдущего
                // массива на максимальноечисло из предыдущего и текущей иетрации
            } else {
                resultList.add(intervals[i]); // просто добавляем
            }
        }
        return resultList.stream().map(a -> Arrays.copyOf(a, a.length)).toArray(int[][]::new);
    }
}
