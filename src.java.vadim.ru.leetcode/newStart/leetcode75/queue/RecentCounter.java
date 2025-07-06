package newStart.leetcode75.queue;

import java.util.ArrayDeque;
import java.util.Deque;
/*
1. Создать пустую очередь.
2. Для каждого вызова ping(t):
   - Добавить t в очередь.
   - Пока первый элемент очереди < t - 3000:
       - Удалить его.
   - Вернуть длину очереди.
 */
public class RecentCounter {
    Deque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
