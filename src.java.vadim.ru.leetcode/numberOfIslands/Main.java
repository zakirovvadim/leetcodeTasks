package numberOfIslands;

/**
 * Реализация отличается от того, как сделано в литКоде, так как там есть валидация на типы char и int, особенно при условии сравнения позиции с 1
 * для этого версия литкода закомментирована и имеет конвертацию всех значений char в строку в каждом условие if.
 *
 * Алгоритм: кратко, проверяем кжадый элемент на 1, меняем значение - информация о том что уже были, и идем по его соседям через рекурсию.
 * Итерируемся по матрице и проверяем каждый элемент на равно 1ю
 * Если да, увеличиваем счетчик, что это новый остров и отправляем в отдельный метод саму матрицу, позицию по горизонтали и позицию по вертикали.
 * Метод осуществляет поиск соседей через условия иф, а перед этим меняет по координатам значение, на любое не один, далее происходит движение вправо влево и верх вниз, с првоеркой что не выходим за границы массивов и число равно 1.
 * Если условия удовлетворяют, вызываем рекурсивно этот же метод и кладем туда матрицу и координаты соседа, которые также будут перезаписаны на не один.
 *
 */
public class Main {
    public static void main(String[] args) {
        char[][] nums = new char[][]{{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        //char[][] nums = new char[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        System.out.println(numIslands(nums));
    }

    public static int numIslands(char[][] grid) {
        int counter = 0;
        if (grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void bfs(char[][] grid, int rowPosition, int cowPosition) {
        grid[rowPosition][cowPosition] = 2;
        if (cowPosition != 0 && grid[rowPosition][cowPosition - 1] == 1) {
            bfs(grid, rowPosition, cowPosition - 1);
        }
        if (cowPosition != grid[rowPosition].length - 1 && grid[rowPosition][cowPosition + 1] == 1) {
            bfs(grid, rowPosition,cowPosition + 1);
        }
        if (rowPosition != 0 && grid[rowPosition - 1][cowPosition] == 1) {
            bfs(grid, rowPosition - 1, cowPosition);
        }
        if (rowPosition != grid.length - 1 && grid[rowPosition + 1][cowPosition] == 1) {
            bfs(grid, rowPosition + 1, cowPosition);
        }
    }
// LeetCode версия
//    public int numIslands(char[][] grid) {
//        int counter = 0;
//        if (grid.length == 0) return 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if ((String.valueOf(grid[i][j]).equals("1"))) {
//                    counter++;
//                    bfs(grid, i, j);
//                }
//            }
//        }
//        System.out.println(counter);
//        return counter;
//    }
//    public void bfs(char[][] grid, int rowPosition, int cowPosition) {
//        grid[rowPosition][cowPosition] = 2;
//        String cow = String.valueOf(cowPosition);
//        if (!cow.equals("0") && String.valueOf(grid[rowPosition][cowPosition - 1]).equals("1")) {
//            bfs(grid, rowPosition, cowPosition - 1);
//        }
//        if (!cow.equals(String.valueOf(grid[rowPosition].length - 1)) && String.valueOf(grid[rowPosition][cowPosition + 1]).equals("1")) {
//            bfs(grid, rowPosition,cowPosition + 1);
//        }
//        if (!String.valueOf(rowPosition).equals("0") && String.valueOf(grid[rowPosition - 1][cowPosition]).equals("1")) {
//            bfs(grid, rowPosition - 1, cowPosition);
//        }
//        if (!String.valueOf(rowPosition).equals(String.valueOf(grid.length - 1)) && String.valueOf(grid[rowPosition + 1][cowPosition]).equals("1")) {
//            bfs(grid, rowPosition + 1, cowPosition);
//        }
//    }
}
