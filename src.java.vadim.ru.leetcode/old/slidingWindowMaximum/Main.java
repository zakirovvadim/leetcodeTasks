package old.slidingWindowMaximum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4};
        int[] ints = maxSlidingWindow(nums, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return new int[0]; // Проверяем на валидность пришедших данных
        Deque<Integer> deQueue = new ArrayDeque<>(); //Инициализируем декью
        List<Integer> result = new ArrayList<>(); // результирующий массив
        for (int i = 0; i < nums.length; i++) {// цикл по индексам
            // Тут проверка на то, что индекс в итерации вышел из окна, т.е. текущая итерация(тобишь индекс) вычитаем размер окна
            // и если разница (тобишь индекс) будет равен тому индексу что у первого элемента в декью (т.е. максимального элемента)
            // то элемент из декью, т.е. его индекс за границей окна. Пример[1,3,| -1,-3,5, |3,6,7] если итерация на индеексе под пятеркой, вычесть у индекса размер окна, то попадем на
            // индекс под тройкой, и если наша тройка максимальная. то ее индекс будет лешать первым в декью, и значит тройка за окном
            if (!deQueue.isEmpty() && deQueue.getFirst() == i - k) {
                deQueue.pollFirst(); // если число за границей окна, значит мы его уже не рассматриваем и удаляем, но так как оно является максимальнм, удаляем первый элемент декью.
            }
            // Проверка на то, что декью содержит индексы, которые ведут к значениям меньше, чем значение по текущей итерации, если это так, то мы удаляем из декью меньшие значения.
            // Т.е. это цикл где мы в условии подсматриваем правый элемент, сравниваем его с итерацией и удаляем из декью
            // Элементы у нас идет от большего к меньшему, поэтому мы итеративно берем с конца и идем в начало
            while(!deQueue.isEmpty() && nums[deQueue.peekLast()] < nums[i]) {
                deQueue.pollLast();
            }
            // Просто добавляем текущий элемент в декью
            deQueue.addLast(i);
            // Условие мб фолс в начале первых k элементов, после, когда итерация стала больше чем k - 1, условие верно
            // Говорит, что если итерация больше/равно чем размер окна минус один, то мы уже имеем нужное окно и вычесленно макс значение, просто добавляем это значение в резалЛист
            if (i >= k - 1) {
                result.add(nums[deQueue.getFirst()]);
            }
        }
        int [] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
