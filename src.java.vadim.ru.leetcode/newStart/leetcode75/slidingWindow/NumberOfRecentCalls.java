package newStart.leetcode75.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
/*
Окно создается с помощью двусторонней очереди.
когда вызывается пинг тебе дают еще и время.
кладем в очередь сразу время.
потом в цикле с условием () - достаем первый элемент пока он меньше t - 3000 мы удаляем его - полл
после того как циклы отработал, возвращаешь размер очереди.
 */
public class NumberOfRecentCalls {
    class RecentCounter {

        Deque<Integer> deque;

        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.addLast(t);
            while (deque.getFirst() < t - 3000) {
                deque.pollFirst();
            }
            return deque.size();
        }
    }



}
