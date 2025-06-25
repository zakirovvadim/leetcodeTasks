package newStart.leetcode75.mapSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Алгоритм следующий
Создаем мапы для строк и столбцов, где ключ будет конкатенация значений через запятую
Далее итерируемся два раза для строк и столбцов с внутренними циклами, где полученные значения склеиваем в строку
с запятой и после внутреннего цикла, помещаем его как ключ в мапу.

Третьим итератором по любой из мапы проверяем еслть ли в другйо мапе такой же ключ, если да, то достаем значения из двух мап по этому ключу
перемножаем (Их произведение даёт количество возможных пар для этого набора значений)
и складываем с внешней переменной подсчета и перезаписываем жту переменную.
 */
public class EqualRowAndColumnPairs {

    public static void main(String[] args) {
        int[][] grid = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        int[][] grid2 = {
                {11,1},
                {1,11}
        };
        /*
        00 01 02
        10 11 12
        20 21 22
         */
        System.out.println(equalPairs(grid2));
    }

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> rowMap = new HashMap<>();
        Map<String, Integer> colMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sr = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sr.append(grid[i][j]).append(",");
            }
            rowMap.put(sr.toString(), rowMap.getOrDefault(sr.toString(), 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            StringBuilder sc = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sc.append(grid[j][i]).append(",");
            }
            colMap.put(sc.toString(), colMap.getOrDefault(sc.toString(), 0) + 1);
        }
        int count =0;
        for (String rowKey : rowMap.keySet()) {
            if (colMap.containsKey(rowKey)) {
                Integer i = colMap.get(rowKey);
                Integer i2 = rowMap.get(rowKey);
                count = count + i * i2;
            }
        }
        return count;
    }
}
