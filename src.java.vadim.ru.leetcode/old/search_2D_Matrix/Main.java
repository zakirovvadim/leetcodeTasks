package old.search_2D_Matrix;

/**
 * Алгоритм схож с бинарным поиском обычного массива.
 * 1. Бинарным поиском ищем нужный массив среди массивов, с той же схемой применения low, right, mid в цикле.
 * 2. Три условия, Первое: если таргет меньше первого элемента массива mid, значит нужные массивы слева, правый офсет смещаем на мид - 1
 * 3. Второе: если таргет больше ПОСЛЕДНЕГО элемента в массиве мид, значит нужные массивы справаб левый офсет смещаем на мид + 1
 * 4. Третье: Если ни первое ни второе условие, значит таргет может быть в текущем массиве мид, внутри создаем новые три офсета и делаем обычный бинарный поиск с циклом внутри массива
 * Таким образом при отсеивании массивов мы попадем в нужный массив и повторим бинарный поиск уже внутри него.
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix2 = new int[][]{{1}, {3}};
        System.out.println(searchMatrix(matrix, 8));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        boolean flag = true;
        while (low <= high) {
            int mid = (low + high) / 2;
            int firstElement = matrix[mid][0];
            int lastElement = matrix[mid][matrix[mid].length - 1];
            if (target == firstElement) return true;
            if (target < firstElement) {
                high = mid - 1;
            } else if (target > lastElement){
                low = mid + 1;
            } else {
                int low2 = 0;
                int high2 = matrix[mid].length - 1;
                while (low2 <= high2) {
                    int mid2 = (low2 + high2) / 2;
                    if (matrix[mid][mid2] == target) return true;
                    if (target < matrix[mid][mid2]) {
                        high2 = mid2 - 1;
                    } else {
                        low2 = mid2 + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
