package newStart.leetcode75.prefix;
/*
Алгоритм не сложный, просто складываем элементы массива между собой и после каждого сложения сравнвиаем с отделеьнгой переменной - максимум
 */
public class FindHighestAltitude {

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
        System.out.println(largestAltitude(new int[]{52,-91,72}));
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int current = 0;
        for (int j : gain) {
            current = current + j;
            max = Math.max(max, current);
        }
        return max;
    }
}
