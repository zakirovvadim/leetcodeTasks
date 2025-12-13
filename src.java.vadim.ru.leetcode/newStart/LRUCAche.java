package newStart;

import java.util.HashMap;
import java.util.Map;
/*
LRU Cache строится на связке из двух структур: HashMap и одного общего двусвязного списка.
HashMap<K, Node> хранит отображение ключ → ссылка на узел списка. Благодаря этому по ключу мы за O(1) получаем именно узел,
и нам не нужно проходить список (нет O(n) “добираться до элемента”).
В узле лежат key и value, а также ссылки prev/next. key в узле нужен, чтобы при выселении быстро удалить запись из map.
Двусвязный список хранит элементы в порядке использования: ближе к голове — самые “свежие” (MRU), ближе к хвосту — самые “старые” (LRU).
Чтобы избежать граничных случаев и null-проверок, обычно используют два фиктивных (sentinel) узла head и tail, так что реальный список всегда выглядит как head <-> ... <-> tail.
Тогда LRU-элемент всегда находится в tail.prev, а самый свежий — в head.next.
Операции:
get(key): найти узел через map. Если нет — вернуть -1. Если есть — вырезать узел из текущего места (через prev/next) и вставить сразу после head,
тем самым пометив его как самый свежий, затем вернуть value.
put(key, value): если ключ уже есть — обновить value, затем так же переместить узел в начало (после head). Если ключа нет — создать новый узел,
вставить его после head и добавить в map. Если после вставки размер превысил capacity, удалить LRU: взять tail.prev, вырезать его из списка и удалить map.remove(lru.key).
Все ключевые действия (поиск по ключу, вырезание/вставка узла, удаление LRU) выполняются за O(1), поэтому get и put имеют амортизированную сложность O(1).
 */
public class LRUCAche {

    public static void main(String[] args) {
        LRUCacheInner cache = new LRUCacheInner(3);
        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);
        cache.put(3, 3);
        System.out.println(cache);
    }

    static class LRUCacheInner {
        Map<Integer, Node> map;
        Node head;
        Node tail;
        int capacity;

        public LRUCacheInner(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node(0, 0, null, null);
            tail = new Node(0, 0, null, null);
            head.next = tail;
            tail.previous = head;
        }

        public int get(int key) {
            Node currentNode = map.get(key);
            if (currentNode == null) return -1;
            unlink(currentNode);
            currentNode.previous = head;
            Node oldNext = head.next;
            currentNode.next = oldNext;
            oldNext.previous = currentNode;
            head.next = currentNode;
            return currentNode.value;
        }

        private static void unlink(Node currentNode) {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node currentNode = map.get(key);
                unlink(currentNode);

                Node oldFirst = head.next;

                currentNode.previous = head;
                currentNode.next = head.next;

                oldFirst.previous = currentNode;
                head.next = currentNode;
                currentNode.value = value;
            } else {
                Node newNode = new Node(key, value, head, head.next);
                head.next.previous = newNode;
                head.next = newNode;
                map.put(key, newNode);

                if (map.size() > capacity) {
                    Node tailPrevious = tail.previous;
                    if (tailPrevious == head) return;
                    Node beforeTailPrev = tailPrevious.previous;
                    int keyForDelete = tailPrevious.key;
                    map.remove(keyForDelete);
                    beforeTailPrev.next = tail;
                    tail.previous = beforeTailPrev;
                }
            }
        }
    }

    static class Node {
        int key;
        int value;
        Node previous;
        Node next;


        public Node(int key, int value, Node previous, Node next) {
            this.key = key;
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
